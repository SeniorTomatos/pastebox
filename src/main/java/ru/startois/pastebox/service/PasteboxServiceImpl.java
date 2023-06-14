package ru.startois.pastebox.service;

import ru.startois.pastebox.api.request.PasteboxRequest;
import ru.startois.pastebox.api.response.PasteboxResponse;
import ru.startois.pastebox.api.response.PasteboxUrlResponse;

import java.util.List;

public class PasteboxServiceImpl implements PasteboxService{
    @Override
    public PasteboxResponse getByHash(String data) {
        return null;
    }

    @Override
    public List<PasteboxResponse> getListPublicPasteboxes(int amount) {
        return null;
    }

    @Override
    public PasteboxUrlResponse create(PasteboxRequest request) {
        return null;
    }
}
