package Controller;

import Service.ICongeService;
import com.gesconge.gesconge.Entities.Conge;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conge")
@RequiredArgsConstructor
public class CongeController {

    @Autowired
    public ICongeService iCongeService;

    public Conge addConge(Conge c) {
        return iCongeService.addConge(c);
    }


    public List<Conge> retreiveAllConges() {

        return iCongeService.retreiveAllConges();
    }


    public Conge retreiveConge(Long Id_Conge) {

        return iCongeService.retreiveConge(Id_Conge);
    }


    public Conge updateConge(Conge c) {

        return iCongeService.updateConge(c);
    }


}
