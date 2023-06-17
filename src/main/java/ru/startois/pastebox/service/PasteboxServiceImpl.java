package ru.startois.pastebox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.startois.pastebox.api.request.PasteboxRequest;
import ru.startois.pastebox.api.request.PublicStatus;
import ru.startois.pastebox.api.response.PasteboxResponse;
import ru.startois.pastebox.api.response.PasteboxUrlResponse;
import ru.startois.pastebox.model.PasteboxEntity;
import ru.startois.pastebox.repository.PasteboxRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
public class PasteboxServiceImpl implements PasteboxService {

    private String host = "http://abc.ru";
    private int publicListSize = 10;

    private final PasteboxRepository repository;
    private AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public PasteboxResponse getByHash(String hash) {
        PasteboxEntity pasteboxEntity = repository.getByHash(hash);
        return new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic());
    }

    @Override
    public List<PasteboxResponse> getListPublicPasteboxes() {
        List<PasteboxEntity> list = repository.getListOfPublicAndAlive(publicListSize);
        return list.stream()
                .map(pasteboxEntity -> new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic()))
                .collect(Collectors.toList());

    }

    @Override
    public PasteboxUrlResponse create(PasteboxRequest request) {

        int hash = generateId();
        PasteboxEntity pasteboxEntity = new PasteboxEntity();
        pasteboxEntity.setData(request.getData());
        pasteboxEntity.setId(hash);
        pasteboxEntity.setHash(Integer.toHexString(hash));
        pasteboxEntity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        pasteboxEntity.setLifeTime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        repository.add(pasteboxEntity);

        return new PasteboxUrlResponse(host + "/" + pasteboxEntity.getHash());
    }

    private int generateId() {
        return idGenerator.getAndIncrement();
    }
}
