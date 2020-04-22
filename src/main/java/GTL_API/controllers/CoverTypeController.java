package GTL_API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import GTL_API.services.ICoverTypeService;

@RestController
@RequestMapping("gtl/coverType")
public class CoverTypeController {

    private ICoverTypeService coverTypeService;

    @Autowired
    public void setCoverTypeService(ICoverTypeService coverTypeService) {
        this.coverTypeService = coverTypeService;
    }

    @RequestMapping(value="/{coverTypeName}", method = RequestMethod.GET)
    public ResponseEntity<?> findCoverTypeByName(@PathVariable String coverTypeName){
        System.out.println("ASD");
        return new ResponseEntity<>(coverTypeService.findCoverTypeByName(coverTypeName), new HttpHeaders(), HttpStatus.FOUND);
    }

}
