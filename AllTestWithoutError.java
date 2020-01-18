import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory(ErrorTests.class)
@Suite.SuiteClasses(FoodTest.class)
public class AllTestWithoutError {

}
