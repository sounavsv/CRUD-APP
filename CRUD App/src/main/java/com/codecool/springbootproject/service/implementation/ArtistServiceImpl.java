package com.codecool.springbootproject.service.implementation;

import com.codecool.springbootproject.model.Artist;
import com.codecool.springbootproject.repository.ArtistRepository;
import com.codecool.springbootproject.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> findAllArtists() {
        log.debug("Fetching all artists");
        return (List<Artist>) artistRepository.findAll();
    }

    @Override
    public Optional<Artist> getArtistById(int id) {
        log.debug("Fetching artist by ID: {}", id);
        return artistRepository.findById(id);
    }

    @Override
    public void deleteArtistById(int id) {
        log.debug("Deleting artist by ID: {}", id);
        artistRepository.deleteById(id);
    }

    @Override
    public long getArtistCount() {
        log.debug("Fetching total count of artists");
        return artistRepository.count();
    }
}
