package Module2.GUI;

import javax.swing.*;

public class MainFrame extends JFrame {
    private MainMenu menu;
    private Page page;
    private PageList pageList;

    private Food[] products = {
            new Food("Cola", 200, 123),
            new Food("Cookies", 50, 245),
            new Food("Aguwa", 185, 75),
            new Food("KitKat", 175, 50)
    };

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Store Application");
        setLayout(null);

        menu = new MainMenu(this);
        menu.setVisible(true);
        add(menu);

        page = new Page(this);
        page.setVisible(false);
        add(page);

        pageList = new PageList(this);
        pageList.setVisible(false);
        add(pageList);
    }

    public MainMenu getMenu() {
        return menu;
    }

    public Page getPage() {
        return page;
    }

    public PageList getPageList() {
        return pageList;
    }

    public Food[] getProducts() {
        return products;
    }

    public void setProducts(Food[] products) {
        this.products = products;
    }
}