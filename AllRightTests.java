import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(RightTests.class)
@Suite.SuiteClasses(FoodTest.class)
public class AllRightTests {
}
