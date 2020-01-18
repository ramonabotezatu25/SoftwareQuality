import org.junit.Test;
import org.junit.Assert;
import org.junit.experimental.categories.Category;

public class FoodTest {


    @Test
    public void testExistence() {
        int[] possibleGrams = {5, 10, 25, 50, 100, 1000};
        Food food = new Food("strawberry", 4, ETaste.sweet, true, possibleGrams);
        Assert.assertNotNull(food);
    }

    @Category(RightTests.class)
    @Test()
    public void setNameTest(){
        Food food = new Food();
        try{
            food.setName("hamburger");
            Assert.assertEquals("hamburger", food.getName());
        } catch (CustomException ex){
            ex.printStackTrace();
            Assert.fail("Name is under the limit lentgh.");
        }

    }

    @Test
    public void getNameTest() {
        Food food = new Food("egg", 21, ETaste.salty, true);
        Assert.assertEquals("egg",  food.getName());

    }

    @Category(RightTests.class)
    @Test
    public void testRighForConstructor() {
        Food food = new Food("cheese case", 433, ETaste.sweet, false);
        Assert.assertEquals("Testing calories setter", 433, food.getCalorioes());
        Assert.assertEquals("Testing taste setter", ETaste.sweet, food.getTaste());

    }

    @Category(RightTests.class)
    @Test
    public void testRightForGrams() {
        int[] possibleGrams = {5, 10, 25, 50, 100, 1000};
        Food food = new Food("strawberry", 4, ETaste.sweet, true, possibleGrams);
        int actualValue = food.maxGrams();
        int expectedValue = 1000;
        Assert.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testInverse(){
        int[] possibleGrams = {1000, 100, 50, 30, 10 };
        Food food = new Food("curry rise", 30, ETaste.spicy, true, possibleGrams);
        int actualValue = food.maxGrams();
        for(int i = 0; i < possibleGrams.length; i++){
            if(possibleGrams[i] == actualValue) {
                i++;
                Assert.assertNotEquals(possibleGrams[i], actualValue);
            }
        }

    }

    @Test
    public void testBoundary() {
        //test for maximum calories accepted
        Food food = new Food("curry rise", 20, ETaste.spicy, true);
        try{
            food.setCalorioes(500);
            Assert.assertEquals("compare calories", 500, food.getCalorioes());


        } catch (CustomException e) {
            e.printStackTrace();
            Assert.fail("If calories are above the maximum number required (500), the set function will throw an error");
        }

    }

    @Category(RightTests.class)
    @Test
    public void testRightForAverageGrmas(){
        int[] possibleGrams = {10, 20, 30};
        Food food = new Food("strawberry", 4, ETaste.sweet, true, possibleGrams);
        int actualValue = food.averageGrams();
        int expectedValue = 20;
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Category(ErrorTests.class)
    @Test(expected = CustomException.class)
    public void testErrorForCalories() throws CustomException {
        Food food= new Food();
        food.setCalorioes(999);
    }

    @Test
    public void testPerformance(){
        int[] possibleGrams = {10, 20, 30, 55, 60, 70, 77, 499, 223,123,122};
        Food food = new Food("strawberry", 4, ETaste.sweet, true, possibleGrams);
        long startTime = System.currentTimeMillis();
        food.averageGrams();
        long stopTime = System.currentTimeMillis();
        long maxTime = 3;
        Assert.assertTrue(maxTime>=stopTime - startTime);

    }

    @Test
    public void testSetHealthy() throws CustomException {
        Food food = new Food("strawberry", 4, ETaste.sweet, true);
        food.setHealthy(true, 100);
        boolean actualValue = food.isHealthy();
        Assert.assertTrue(actualValue);

    }

    @Category(ErrorTests.class)
    @Test(expected = CustomException.class)
    public void testErrorForSetHealthy() throws CustomException {
        Food food = new Food("strawberry", 4, ETaste.sweet, true);
        food.setHealthy(true, 775);
        boolean actualValue = food.isHealthy();
        Assert.assertTrue(actualValue);
    }

    @Category(RightTests.class)
    @Test
    public void testRightForSetGrams(){
        int[] possibleGrams = {10, 20, 30};
        Food food = new Food();
        food.setPossibleGrams(possibleGrams);
        int[] expectedValue = food.getPossibleGrams();
        Assert.assertEquals(expectedValue, possibleGrams);
    }

    @Category(RightTests.class)
    @Test
    public void testRightForTatse(){
        Food food = new Food();
        food.setTaste(ETaste.sweet);
        Assert.assertEquals(food.getTaste(), ETaste.sweet);
    }

}