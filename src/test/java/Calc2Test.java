import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Calc2Test {


    @Test
    void calculateShouldReturn6() {
        //given
        String str = "1 + 2 * 3 + -1";

        //when
        int result = Calc2.calculate(str);

        //then
        assertThat(result).isEqualTo(6);
    }


    @Test
    void calculateShouldReturn41() {
        //given
        String str = "1 + 20 * ( 3 + -1 )";

        //when
        int result = Calc2.calculate(str);

        //then
        assertThat(result).isEqualTo(41);
    }


    @Test
    void calculateShouldReturn42() {
        //given
        String str = "( 1 + 20 ) * ( 3 + -1 )";

        //when
        int result = Calc2.calculate(str);

        //then
        assertThat(result).isEqualTo(42);
    }


    @Test
    void calculateShouldReturnMinus5() {
        //given
        String str = "1 + ( 2 * 3 ) / -1";

        //when
        int result = Calc2.calculate(str);

        //then
        assertThat(result).isEqualTo(-5);
    }


}
