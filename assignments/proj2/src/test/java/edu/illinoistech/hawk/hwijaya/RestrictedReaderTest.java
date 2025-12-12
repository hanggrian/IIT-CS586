package edu.illinoistech.hawk.hwijaya;

import java.io.BufferedReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestrictedReaderTest {
    @Mock private BufferedReader reader;

    @Test
    public void matching() throws IOException {
        when(reader.readLine()).thenReturn("bar");
        assertThat(new RestrictedReader(reader).readText(new String[]{"foo", "bar"}, true))
            .isEqualTo("bar");

        when(reader.readLine()).thenReturn("2");
        assertThat(new RestrictedReader(reader).readNumber(1, 3))
            .isEqualTo(2);

        when(reader.readLine()).thenReturn("3.0");
        assertThat(new RestrictedReader(reader).readDecimal(0, 5))
            .isEqualTo(3f);
    }

    @Test
    public void restricted() throws IOException {
        when(reader.readLine()).thenReturn("baz");
        assertThat(new RestrictedReader(reader).readText(new String[]{"foo", "bar"}, true))
            .isNull();

        when(reader.readLine()).thenReturn("4");
        assertThat(new RestrictedReader(reader).readNumber(1, 3, true))
            .isEqualTo(-1);

        when(reader.readLine()).thenReturn("6");
        assertThat(new RestrictedReader(reader).readNumber(0, 5, true))
            .isEqualTo(-1);
    }

    @Test
    public void invalidParameter() {
        assertThrows(
            NullPointerException.class,
            () -> new RestrictedReader(null)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> new RestrictedReader().readText(new String[0], true)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> new RestrictedReader().readNumber(2, 1, true)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> new RestrictedReader().readDecimal(5f, 4f, true)
        );
    }
}
