package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.dtos.ImageDTO;
import br.com.walkito.fichaOnline.model.dtos.LoginDTO;
import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.service.AccountService;
import br.com.walkito.fichaOnline.service.FileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/account")
public class AccountController {
    @Autowired
    AccountService service;
    @Autowired
    FileService fileService;

    @GetMapping(path = "/accountInfos")
    public ResponseEntity<Object> getAccountInfos(@RequestParam(name = "id") int id){
        return service.getAccountInfos(id);
    }

    @GetMapping(path = "/accountInfos/user")
    public ResponseEntity<Object> getAccountInfosByUser(@RequestParam(name = "user") String user){
        return service.getAccountInfosByUser(user);
    }

    @GetMapping(path = "/linkedRuns")
    public ResponseEntity<Object> getLinkedRuns(@RequestParam(value = "idAccount", defaultValue = "0")
                                                int idAccount){
        return service.getLinkedRuns(idAccount);
    }

    @GetMapping(path = "/verifyEmailUser")
    public ResponseEntity<Object> verifyEmailUser(@RequestParam(value = "email") String email,
                                                  @RequestParam(value = "user") String user,
                                                  @RequestParam(value = "id") int id){
        return service.verifyEmailUser(email, user, id);
    }

    @GetMapping(path = "/download")
    public ResponseEntity<Object> downloadProfileImage(@RequestParam(value = "id") int id){
        String fileName = service.getAccountProfilePictureName(id);
        return fileService.downloadFile("profile", fileName);
    }



    @PostMapping(path = "/authLogin")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) {
        return service.doLogin(loginDTO.getUser(), loginDTO.getPassword());
    }

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<Object> createAccount(@RequestBody @Valid Account account){
        return service.createAccount(account);
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<Object> uploadProfileImage(@RequestBody ImageDTO image){
        String olderFileName = service.saveFileName(image.getId(), image.getFileName());
        return fileService.uploadFile(olderFileName,"profile", image);
    }



    @PutMapping(path = "/edit")
    public ResponseEntity<Object> editAccount(@RequestBody @Valid Account account){
        return service.editAccount(account);
    }



    @DeleteMapping(path = "/delete")
    public ResponseEntity<Object> deleteAccount(@RequestParam("idAccount") int idAccount){
        return service.deleteAccount(idAccount);
    }
}
