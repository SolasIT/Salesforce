package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getAccount(String rating, String fax, String number,
                                     String type, String ownership, String industry,
                                     String employees, String ticker, String revenue) {
        Faker faker = new Faker();

        return new Account(
                rating,
                faker.company().name(),
                faker.phoneNumber().cellPhone(),
                fax,
                faker.internet().domainName(),
                number,
                faker.internet().domainName(),
                ticker,
                employees,
                revenue,
                faker.number().digits(4),
                type,
                industry,
                ownership,
                faker.address().fullAddress(),
                faker.address().fullAddress()
        );
    }
}