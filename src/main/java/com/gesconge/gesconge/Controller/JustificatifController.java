package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Services.IJustificatifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
@RestController
@RequestMapping("Justificatif")
public class JustificatifController {
    @Autowired
    IJustificatifService JustSer;

    @PostMapping(value = "/justificatifs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> UploadJust(@RequestPart("pdf") MultipartFile pdfFile ,
                                        @RequestParam("nom") String libelle) throws IOException {
        return JustSer.UploadJust(pdfFile,libelle);
    }
    @GetMapping("/justificatifs/{id}/pdf")

    public ResponseEntity<byte[]> DownloadJustificatif(@PathVariable int id) {
        return JustSer.DownloadJustificatif(id);
    }
}
