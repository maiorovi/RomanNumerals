package logic;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsMapperTest {

    private RomanNumeralsMapper mapper;

    @Before
    public void setUp() {
        mapper = new RomanNumeralsMapper();
    }

    @Test
    public void mapsITo1() {
        assertThat(mapper.getDeciamlValueFrom("I")).isEqualTo(1);
    }

    @Test
    public void mapsVTo5() {
        assertThat(mapper.getDeciamlValueFrom("V")).isEqualTo(5);
    }

    @Test
    public void mapsXTo10() {
        assertThat(mapper.getDeciamlValueFrom("X")).isEqualTo(10);
    }

    @Test
    public void mapsLTo50() {
        assertThat(mapper.getDeciamlValueFrom("L")).isEqualTo(50);
    }

    @Test
    public void mapsCTo100() {
        assertThat(mapper.getDeciamlValueFrom("C")).isEqualTo(100);
    }

    @Test
    public void mapsDTo500() {
        assertThat(mapper.getDeciamlValueFrom("D")).isEqualTo(500);
    }

    @Test
    public void mapsMTo1000() {
        assertThat(mapper.getDeciamlValueFrom("M")).isEqualTo(1000);
    }
}
