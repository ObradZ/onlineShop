package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActionFigure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    private short categoryid;
    private String name;
    private int price;
    private int height;
    private int width;
    private String image;
    private short stack;

    /**
     * @return the id
     */
    public short getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(short id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the height
     */
    public int getHeight() {
	return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
	this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
	return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
	this.width = width;
    }

    /**
     * @return the image
     */
    public String getImage() {
	return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
	this.image = image;
    }

    /**
     * @return the categoryID
     */


    /**
     * @return the price
     */
    public int getPrice() {
	return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
	this.price = price;
    }

    /**
     * @return the stack
     */
    public short getStack() {
	return stack;
    }

    /**
     * @param stack the stack to set
     */
    public void setStack(short stack) {
	this.stack = stack;
    }

    /**
     * @return the categoryid
     */
    public short getCategoryid() {
	return categoryid;
    }

    /**
     * @param categoryid the categoryid to set
     */
    public void setCategoryid(short categoryid) {
	this.categoryid = categoryid;
    }

    /**
     * @return the productID
     */
}
