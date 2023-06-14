package ru.startois.pastebox.service;

import ru.startois.pastebox.api.request.PasteboxRequest;
import ru.startois.pastebox.api.response.PasteboxResponse;
import ru.startois.pastebox.api.response.PasteboxUrlResponse;

import java.util.List;

public interface PasteboxService {
    PasteboxResponse getByHash(String data);
    List<PasteboxResponse> getListPublicPasteboxes ();
    PasteboxUrlResponse create(PasteboxRequest request);
}
