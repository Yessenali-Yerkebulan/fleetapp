package com.yessenali.fleetapp.services;

import com.yessenali.fleetapp.models.JobTitle;
import com.yessenali.fleetapp.models.Location;
import com.yessenali.fleetapp.repositories.JobTitleRepository;
import com.yessenali.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;

    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }

    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    public void delete(Integer id){
        jobTitleRepository.deleteById(id);
    }
}
