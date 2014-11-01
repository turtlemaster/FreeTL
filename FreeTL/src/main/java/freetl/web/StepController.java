package freetl.web;

import freetl.descriptor.StepParameterDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import freetl.descriptor.StepDescriptor;
import freetl.operation.Step;
import freetl.operation.Transform;
import freetl.operation.input.CSVInput;
import freetl.util.StepCollection;
import freetl.util.TransformRetriever;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/step")
@SessionAttributes("descriptor")

public class StepController {
    @RequestMapping(value = "/confirmEdit", method = RequestMethod.POST)
    public ModelAndView confirmEdit(@ModelAttribute("descriptor") StepDescriptor descriptor,
                                    @ModelAttribute("removedIds") String removedIds,
                                    @ModelAttribute("transformName") String transformName,
                                    BindingResult bindingResult) throws IOException {


        ModelAndView model = new ModelAndView();
        model.getModel().put("descriptor", descriptor);
        model.getModel().put("transformName", transformName);
        model.getModel().put("removedIds", removedIds);

        model.setViewName("page.step.confirmEdit");

        return model;
    }

    @RequestMapping(value = "/processEdit", method = RequestMethod.POST)
    public ModelAndView processEdit(@ModelAttribute("descriptor") StepDescriptor descriptor,
                                    @ModelAttribute("removedIds") String removedIds,
                                    @ModelAttribute("transformName") String transformName,
                                    BindingResult bindingResult) throws IOException {


        UUID stepId = UUID.fromString(descriptor.getId());

        TransformRetriever retriever = new TransformRetriever();
        Transform transform = retriever.getTransform(transformName);

        StepCollection stepCollection = transform.getStepCollection();
        Step step = stepCollection.getStepWithId(stepId);


        if (step instanceof CSVInput) {
            CSVInput csvInput = (CSVInput) step;


            if (!removedIds.isEmpty()) {
                List<Integer> indeces = new ArrayList<Integer>();

                String[] rawFieldTypes = removedIds.split(",");
                for (String type : rawFieldTypes) {
                    String fieldType = type.substring("fieldtype_".length(), type.length());
                    indeces.add(Integer.valueOf(fieldType));
                }
                Collections.sort(indeces, Collections.reverseOrder());

                for (Integer i : indeces) {
                    csvInput.removeFieldType(i);
                }
            }
        }



        ModelAndView model = new ModelAndView();

        model.getModel().put("descriptor", descriptor);
        model.getModel().put("transformName", transformName);
        return  model;
    }


    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "filename", required = true) String filename,
                             @RequestParam(value = "id", required = true) String id) throws IOException {

        TransformRetriever retriever = new TransformRetriever();
        Transform t = retriever.getTransform(filename);

        UUID stepId = UUID.fromString(id);
        Step s = t.getStepCollection().getStepWithId(stepId);

        StepDescriptor descriptor = s.getDescriptor();


        ModelAndView model = new ModelAndView();
        model.getModel().put("descriptor", descriptor);

        model.getModel().put("transformName", filename);


        model.setViewName("page.step.CSVInput");

        return model;
    }




}
