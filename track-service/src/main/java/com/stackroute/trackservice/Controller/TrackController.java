package com.stackroute.trackservice.Controller;
import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/v1")
  public class TrackController {
  private TrackService trackService;
  public TrackController() {
  }
  @Autowired
  public TrackController(TrackService trackService) {
    this.trackService = trackService;
  }
  @PostMapping("track")
  public ResponseEntity<?> saveTrack(@RequestBody Track track) {
    ResponseEntity responseEntity;
    try {
      trackService.saveTrack(track);
      responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
    } catch (TrackAlreadyExistsException e) {
      responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }
  @GetMapping("track/{id}")
  public ResponseEntity<?> getTrackById(@PathVariable int id){
      ResponseEntity responseEntity;
      try{
        responseEntity=new ResponseEntity<Track>(trackService.getTrackById(id),HttpStatus.FOUND);
      }catch(TrackNotFoundException e)
      {
        responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
      }
      return responseEntity;
  }
  @GetMapping("tracks")
  public ResponseEntity<?> getAllTracks() {
    ResponseEntity responseEntity;
    try{
      responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.FOUND);
    }catch(Exception e)
    {
      responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
    }
    return responseEntity;
  }
  @DeleteMapping("track/{id}")
  public ResponseEntity<?> deleteTrackById(@PathVariable int id, ResponseEntity<Optional<Track>> responseEntity){
    try{
      responseEntity = new ResponseEntity<Optional<Track>>(Optional.ofNullable(trackService.deleteTrackById(id)),HttpStatus.OK);
    }
    catch (Exception e){
      responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
    }
    return responseEntity;
  }
  @PutMapping("track/{id}")
  public ResponseEntity<?> updateTrackById(@PathVariable int id, @RequestBody Track track, ResponseEntity responseEntity){

    try{
      responseEntity = new ResponseEntity(trackService.updateTrackById(id,track),HttpStatus.ACCEPTED);
    }
    catch (Exception e){
      responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
    }
    return responseEntity;
  }
  @GetMapping("tracks/{name}")
  public ResponseEntity<?> getTrackByName(@PathVariable String name, ResponseEntity<Track> responseEntity){
    try{
      responseEntity = new ResponseEntity<Track>((MultiValueMap<String, String>) trackService.getTrackByName(name),HttpStatus.FOUND);
    }
    catch (Exception e){
      responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
    }
    return responseEntity;
  }
}


