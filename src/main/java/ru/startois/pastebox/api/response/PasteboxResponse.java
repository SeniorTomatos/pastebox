package ru.startois.pastebox.api.response;

import lombok.Data;
import ru.startois.pastebox.api.request.PublicStatus;

@Data
public class PasteboxResponse {
    private String data;
    private PublicStatus status;
}
