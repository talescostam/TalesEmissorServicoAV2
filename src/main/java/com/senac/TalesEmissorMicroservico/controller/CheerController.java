package com.senac.TalesEmissorMicroservico.controller;

import com.senac.TalesEmissorMicroservico.entity.Cheer;
import com.senac.TalesEmissorMicroservico.service.CheerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheerController {

    private final CheerService cheerService;

    @Autowired
    public CheerController(CheerService cheerService) {
        this.cheerService = cheerService;
    }

    @PostMapping("/cheer")
    public void postCheer(@RequestBody String name) {
        Cheer cheer = new Cheer();
        cheer.setName(name);
        cheerService.sendCheerMessage(cheer);
    }
}
