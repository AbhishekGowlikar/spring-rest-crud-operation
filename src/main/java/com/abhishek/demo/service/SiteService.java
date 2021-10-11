package com.abhishek.demo.service;

import com.abhishek.demo.model.Site;
import com.abhishek.demo.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    public List<Site> getAllSites(){
        return siteRepository.findAll();
    }

    public Site getSite(int siteId){
        return siteRepository.findById(siteId).get();
    }

    public Site createOrUpdateSite(Site site){
        Optional<Site> siteObj = siteRepository.findById(site.getSiteId());
        if (siteObj.isPresent()) {

            Site siteEntity = siteObj.get();
            siteEntity.setSiteName(siteEntity.getSiteName());
            siteEntity.setSiteOwner(siteEntity.getSiteOwner());

            siteEntity = siteRepository.save(siteEntity);

            return siteEntity;
        } else {
            site = siteRepository.saveAndFlush(site);
            return site;
        }
    }

    /**
     * To delete the site from DB.
     * @param siteId
     */
    public String deleteSite(int siteId){

        boolean flag = siteRepository.existsById(siteId);
        if(flag)
        {
            siteRepository.deleteById(siteId);
            return "SUCCESS";
        }
        return "FAILURE";
    }
}
