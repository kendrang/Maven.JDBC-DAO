package daos;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class daoTest {

    DaoConcrete carDao;

    @Before
    public void setup() {
        carDao = new DaoConcrete();
    }

    @Test
    public void findByIdTest(){
        Cars myCar = (Cars) carDao.findById(1);
        Assert.assertEquals("Jaguar", myCar.getMake());
    }

    @Test
    public void findAllTest(){
        List<Cars> mycars = carDao.findAll();

        Assert.assertEquals("Mercury", mycars.get(1).getMake());
        Assert.assertEquals("GMC", mycars.get(2).getMake());
        Assert.assertEquals("Nissan", mycars.get(3).getMake());
    }

    @Test
    public void updateTest(){
        Cars test = new Cars(11,"Pikachu PunchBuggie", "Pikachu", 2000, "Yellow", "12345Pika");
        carDao.create(test);

        List<Cars> mycars = carDao.findAll();
        mycars.add(test);
        test.setModel("Pika");
        carDao.update(test);
        Assert.assertEquals("Pika", mycars.get(mycars.size()-1).getModel());

    }

    @Test
    public void createTest() {
        Cars test = new Cars(11,"Pikachu PunchBuggie", "Pikachu", 2000, "Yellow", "12345Pika");
        carDao.create(test);

        List<Cars> mycars = carDao.findAll();
        mycars.add(test);
        carDao.update(test);
        Assert.assertEquals("Pikachu", mycars.get(mycars.size()-1).getModel());
    }

    @Test
    public void deleteTest(){
        Cars test = new Cars(11,"Pikachu PunchBuggie", "Pikachu", 2000, "Yellow", "12345Pika");
        carDao.create(test);

        List<Cars> mycars = carDao.findAll();
        mycars.add(test);
        carDao.delete(11);
        carDao.update(test);
        Assert.assertEquals(10, mycars.size());

    }
}
