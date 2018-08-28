package algorithms.greedyflorist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

public class SolutionTest implements ArgumentsProvider {
  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(13, 3, new int[]{2, 5, 6}),
      Arguments.of(15, 2, new int[]{2, 5, 6}),
      Arguments.of(29, 3, new int[]{1, 3, 5, 7, 9}),
      Arguments.of(54351386, 54, new int[]{755351, 315794, 985476, 418333, 85872, 966900, 452133, 633413, 538488, 172379,
        380416, 591036, 933003, 454684, 436416, 885565, 775486, 430343, 888367, 422013, 563116, 599053, 383505, 168228,
        907438, 174347, 575982, 494697, 160360, 168119, 164910, 184136, 95488, 934822, 946780, 982051, 893930, 530231,
        651789, 508403, 960095, 224, 62490, 491625, 234413, 979859, 122056, 275237, 287335, 926220, 495049, 423698,
        906172, 296442, 52892, 686236, 937701, 733639, 749135, 69711, 295416, 440582, 802660, 560973, 721946, 824,
        67346, 656299, 871121, 567995, 390754, 334634, 537976, 966480, 243514, 363917, 29323, 728519, 137335, 802715,
        868130, 702729, 439155, 114547, 974331, 273026, 850662, 643335, 941232, 177897}),
      Arguments.of(163578911, 3, new int[]{390225, 426456, 688267, 800389, 990107, 439248, 240638, 15991, 874479, 568754,
        729927, 980985, 132244, 488186, 5037, 721765, 251885, 28458, 23710, 281490, 30935, 897665, 768945, 337228,
        533277, 959855, 927447, 941485, 24242, 684459, 312855, 716170, 512600, 608266, 779912, 950103, 211756,
        665028, 642996, 262173, 789020, 932421, 390745, 433434, 350262, 463568, 668809, 305781, 815771, 550800})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void testGetMinimumCost(int expected, int friendsCount, int[] flowersPrice) {
    Assertions.assertEquals(expected, Solution.getMinimumCost(friendsCount, flowersPrice));
  }
}

