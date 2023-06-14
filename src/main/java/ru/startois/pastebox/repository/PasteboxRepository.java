package ru.startois.pastebox.repository;

import ru.startois.pastebox.model.PasteboxEntity;

import java.util.List;

public interface PasteboxRepository {
    PasteboxEntity getByHash(String hash);

    List<PasteboxEntity> getListOfPublicAndAlive(int amount);

    PasteboxEntity add(PasteboxEntity pasteboxEntity);

}
