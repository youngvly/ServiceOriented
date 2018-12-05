package koreatech.cse.service.worknet;

import koreatech.cse.domain.worknet.WorkNetItem;
import koreatech.cse.repository.WorknetMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class WorknetService {

    @Inject
    private WorknetMapper worknetMapper;

    public void insertWork(WorkNetItem workNetItem){
        System.out.println(workNetItem.toString());
        worknetMapper.insert(workNetItem);
    }
}
