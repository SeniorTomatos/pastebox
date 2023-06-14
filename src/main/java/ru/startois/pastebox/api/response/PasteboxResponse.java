package ru.startois.pastebox.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.startois.pastebox.api.request.PublicStatus;

@Data
@RequiredArgsConstructor
public class PasteboxResponse {
    private final String data;
    private final boolean isPublic;
}
