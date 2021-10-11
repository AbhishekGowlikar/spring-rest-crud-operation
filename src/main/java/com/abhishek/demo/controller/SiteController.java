package com.abhishek.demo.controller;

import com.abhishek.demo.model.Site;
import com.abhishek.demo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/sites")
public class SiteController {

    @Autowired
    SiteService siteService;

    ConcurrentMap<String, Site> sites = new ConcurrentHashMap<>();

    @GetMapping
    public ResponseEntity<List<Site>> getAllSites() {
        List<Site> list = siteService.getAllSites();
        return new ResponseEntity<List<Site>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{siteId}")
    public ResponseEntity<Site> getSite(@PathVariable("siteId") int siteId)  {
        Site site = siteService.getSite(siteId);
        return new ResponseEntity<Site>(site, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/insert/{site_name}/{site_owner}")
    public ResponseEntity<Site> createOrUpdateSite(@PathVariable("site_name") String siteName,
                                                       @PathVariable("site_owner") String siteOwner)
                                                       throws Exception {
        Site site = new Site();
        site.setSiteName(siteName);
        site.setSiteOwner(siteOwner);

        Site updated = siteService.createOrUpdateSite(site);
        return new ResponseEntity<Site>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{site_id}")
    public HttpStatus deleteSite(@PathVariable("site_id") int site_id)  {
           String  retVal = siteService.deleteSite(site_id);
           if(retVal.equalsIgnoreCase("SUCCESS"))
           {
            return  HttpStatus.OK;
           }
           else
           {
               return HttpStatus.NOT_FOUND;
           }

    }


}
