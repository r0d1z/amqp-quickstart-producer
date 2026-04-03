package rodrigo.queiroz;

import org.junit.jupiter.api.Test;

import rodrigo.queiroz.model.Quote;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QuoteTest {

    @Test
    void testQuoteInstantiation() {
        Quote quote = new Quote("12345", 100);
        assertNotNull(quote);
    }
}
