package ru.startois.pastebox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.startois.pastebox.api.request.PasteboxRequest;
import ru.startois.pastebox.api.response.PasteboxResponse;
import ru.startois.pastebox.api.response.PasteboxUrlResponse;
import ru.startois.pastebox.service.PasteboxService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class PasteboxController {

    private final PasteboxService pasteboxService;

    @GetMapping("/")
    public Collection<PasteboxResponse> getPublicPasteList() {
        return pasteboxService.getListPublicPasteboxes();
    }

    @GetMapping("/{hash}")
    public PasteboxResponse getByHash(@PathVariable String hash) {
        return pasteboxService.getByHash(hash);
    }

    @PostMapping("/")
    public PasteboxUrlResponse add(@RequestBody PasteboxRequest request) {
        return pasteboxService.create(request);
    }
}
