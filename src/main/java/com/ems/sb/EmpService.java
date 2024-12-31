package com.ems.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepo;

    public EmpBean addEmp(EmpBean empBean){
        EmpEntity empEntity = new EmpEntity(empBean.getId(), empBean.getName(), empBean.getDept());
        EmpEntity dbEmpEntity = empRepo.save(empEntity);
        return new EmpBean(dbEmpEntity.getId(), dbEmpEntity.getName(), dbEmpEntity.getDept());
    }
    public List<EmpBean> getAllEmp(){
        List<EmpEntity> lstEmp = empRepo.findAll();
        List<EmpBean> lstEmpBean = new ArrayList<>();

        if(!lstEmp.isEmpty()){
            for(EmpEntity dbEmpEntity : lstEmp)
                lstEmpBean.add(new EmpBean(dbEmpEntity.getId(), dbEmpEntity.getName(), dbEmpEntity.getDept()));
        }
        return lstEmpBean;
    }
}
