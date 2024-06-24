package apiTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class Arggre {

    @ParameterizedTest
    @CsvSource({
            "John, Doe, M, 1990-05-20",
            "Jane, Dape, F, 1990-04-20"
    })
    void Aggregate(ArgumentsAccessor args){
        System.out.println(args.get(0));
        System.out.println(args.get(3));
    }
}
