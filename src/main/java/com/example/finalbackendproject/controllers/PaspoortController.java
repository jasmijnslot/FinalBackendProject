package com.example.finalbackendproject.controllers;

//import com.example.finalbackendproject.Response;
import com.example.finalbackendproject.dtos.PaspoortDTO;
import com.example.finalbackendproject.models.Paspoort;
import com.example.finalbackendproject.services.PaspoortService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaspoortController {

    @Autowired
    private PaspoortService paspoortService;

    @PostMapping("/paspoorten")
    public PaspoortDTO nieuwPaspoort(@RequestBody PaspoortDTO paspoortDTO){
        return paspoortService.nieuwPaspoort(paspoortDTO);
    }

    @GetMapping("/paspoorten")
    public List<PaspoortDTO> allePaspoorten(){
        return paspoortService.allePaspoorten();
    }

    @GetMapping("/paspoorten/{id}")
    public PaspoortDTO paspoortPerId(@PathVariable Long id){
        return paspoortService.paspoortPerId(id);
    }

    @DeleteMapping("/paspoorten/{id}")
    public String verwijderPaspoort(@PathVariable Long id){
        return paspoortService.verwijderPaspoort(id);
    }


    //@PostMapping("/paspoorten/uploadScan")
    //public Response uploadFile(@RequestParam("file") MultipartFile file) {
    //    Paspoort nummer = paspoortService.paspoortOpslag(file);

    //    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
     //           .path("/uploadScan/")
    //            .path(nummer.getNummer())
    //            .toUriString();

    //    return new Response(nummer.getNummer(), fileDownloadUri,
    //            file.getContentType(), file.getSize());
  //  }

   // @GetMapping("/paspoorten/downloadFile/{nummer:.+}")
   // public ResponseEntity < Resource > downloadFile(@PathVariable Long id, HttpServletRequest request) {
   //     Paspoort paspoort = paspoortService.krijgPaspoort(id);

    //    return ResponseEntity.ok()
     //           .contentType(MediaType.parseMediaType(paspoort.getContentType()))
     //           .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + paspoort.getNummer() + "\"")
     //           .body(new ByteArrayResource(paspoort.getPaspoortScan()));
   // }




}
