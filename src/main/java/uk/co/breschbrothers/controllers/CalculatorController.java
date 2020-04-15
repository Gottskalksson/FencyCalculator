package uk.co.breschbrothers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uk.co.breschbrothers.daos.AnotherDao;
import uk.co.breschbrothers.daos.FencyDao;
import uk.co.breschbrothers.daos.RailDao;
import uk.co.breschbrothers.entity.*;
import uk.co.breschbrothers.pojos.Item;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {

    private final FencyDao fencyDao;
    private final RailDao railDao;
    private final AnotherDao anotherDao;

    @Autowired
    public CalculatorController(FencyDao fencyDao, RailDao railDao, AnotherDao anotherDao) {
        this.fencyDao = fencyDao;
        this.railDao = railDao;
        this.anotherDao = anotherDao;
    }

    @GetMapping("/calculator")
    public String calculator(Model model) {
        List<Fency> fencyList = fencyDao.findAll();
        model.addAttribute("fencyList", fencyList);
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calcForm (@RequestParam String fencyList, @RequestParam String fenceLength, Model model) {
        Fency fency = fencyDao.findById(Long.parseLong(fencyList));
        Post post = fency.getPost();
        Rail rail = railDao.findById(1);
        Another nails = anotherDao.findById(1);
        Another job = anotherDao.findById(2);
        Another postcrete = anotherDao.findById(3);

        List<Item> itemList = new ArrayList<>();

        addItemToList(fency, itemList, fenceLength);
        addItemToList(post, itemList, fenceLength);
        addItemToList(rail, itemList, fenceLength);

        itemList.add(new Item("Nails", nails.getType(), 1, nails.getPrice(), nails.getPrice()));
        itemList.add(new Item("Job", job.getType(), 1, job.getPrice(), job.getPrice() * Double.parseDouble(fenceLength)));

        int postcreteQuantity = (int) (Double.parseDouble(fenceLength) * 1.1) + 1;
        itemList.add(new Item("Postcrete", postcrete.getType(), postcreteQuantity, postcrete.getPrice(), postcrete.getPrice() * postcreteQuantity));

        model.addAttribute("itemList", itemList);
        return "result";
    }

    private void addItemToList (EntityBase entityBase, List<Item> itemList, String length) {
        double lengthInMeter = Double.parseDouble(length);

        Item item = new Item();
        item.setType(entityBase.getType());
        item.setPriceForEach(entityBase.getPricePerPiece());
        int quantity;

        if (entityBase instanceof Fency) {
            item.setDescription("Boards");
            quantity = (int) (lengthInMeter * 1000 / (entityBase.getWidth() + 15)) + 1;
        } else if (entityBase instanceof Post) {
            item.setDescription("Posts");
            quantity = (int) (lengthInMeter * 0.6 + 1);
        } else {
            item.setDescription("Rails");
            quantity = (int) lengthInMeter;
        }

        item.setQuantity(quantity);
        item.setTotalPrice();

        itemList.add(item);

    }


}
