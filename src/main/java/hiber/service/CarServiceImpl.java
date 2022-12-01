package hiber.service;

import hiber.dao.CarDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;
    @Transactional(readOnly = true)
    @Override
    public User getUserByCar(String parModel, int parSeries) {
        return carDao.getUserByCar(parModel, parSeries);
    }
}