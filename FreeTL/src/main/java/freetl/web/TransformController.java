package freetl.web;

import freetl.test.User;
import freetl.util.PersistenceManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import freetl.exceptions.StepException;
import freetl.io.Transforms;
import freetl.operation.Transform;
import freetl.util.TransformRetriever;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/transform")


public class TransformController {

    @RequestMapping("/view")
    public ModelAndView viewTransform(@RequestParam(value = "filename", required = true) String filename) throws IOException {


        TransformRetriever retriever = new TransformRetriever();
        Transform t = retriever.getTransform(filename);


        ModelAndView model = new ModelAndView();


        model.getModel().put("stepDescriptors", retriever.getStepDescriptors(t));
        model.getModel().put("routes", retriever.getRoutes(t));
        model.getModel().put("transform", t);
        model.getModel().put("filename", filename);
        model.getModel().put("iconIds", retriever.getIds(retriever.getStepDescriptors(t)));
        model.setViewName("page.transform.view");

        return model;
    }

    @RequestMapping("/run")
    public String runTransform(@RequestParam(value = "filename", required = true) String filename, Model model) throws IOException {
        TransformRetriever retriever = new TransformRetriever();
        Transform t = retriever.getTransform(filename);
        try {
            t.run();
        } catch (StepException e) {
            e.printStackTrace();
        }


        model.addAttribute("contentTemplate", "transform/run");
        model.addAttribute("contentFragment", "runTransform");
        return WebUtil.MAIN_LAYOUT;
    }

    @RequestMapping("/list")
    public ModelAndView transformList() {


        ModelAndView model = new ModelAndView();
        List<String> filenames = Transforms.getTransformFilenames("/Users/turtlemaster/Programming/FreeTL/src/test/resources");
        model.getModel().put("filenames", filenames);

        model.setViewName("page.transform.list");

        testJPA();

        return model;

    }



    public void testJPA() {
        EntityManager em = PersistenceManager.getEntityManager();

        // Read the existing entries and write to console

        Query q = em.createQuery("SELECT u FROM User u WHERE u.name = :userId");
        q.setParameter("userId", 701);
        List<User> userList = q.getResultList();
        for (User user : userList) {
            System.out.println(user.getId());
            System.out.println(user.getName());

        }
        System.out.println("Size: " + userList.size());

        // Create new user
        em.getTransaction().begin();

        User user = new User();
        user.setName("Tom Johnson");

        em.persist(user);
        em.getTransaction().commit();

        em.close();
    }






}


