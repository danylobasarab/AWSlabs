package ua.lviv.iot.lab4.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.iot.lab4.controller.*;
import ua.lviv.iot.lab4.model.*;

import java.util.*;

@Component
public class MyView {
    private final CityController cityController;
    private final CountryController countryController;
    private final CredentialController credentialController;

    private final EstablishmentController establishmentController;

    private final InformationAboutOwnerController informationAboutOwnerController;

    private final ReviewOfEstablishmentController reviewOfEstablishmentController;

    private final StreetController streetController;

    private final TypeOfEstablishmentController typeOfEstablishmentController;

    private final UserAccountController userAccountController;

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    private final City nullCity = new City(null, null, null);
    private final Country nullCountry = new Country(null);
    private final Credential nullCredential = new Credential(null, null, null);
    private final Establishment nullEstablishment = new Establishment(null, null, null, 0, null, null);
    private final InformationAboutOwner nullInformationAboutOwner = new InformationAboutOwner(null, null, null, 0, 0);
    private final ReviewOfEstablishment nullReviewOfEstablishment = new ReviewOfEstablishment(null, null, null);
    private final Street nullStreet = new Street(null, null, null);
    private final TypeOfEstablishment nullTypeOfEstablishment = new TypeOfEstablishment(null, null);
    private final UserAccount nullUserAccount = new UserAccount(null, null, null, null);

    @Autowired
    public MyView(CityController cityController,
                  CountryController countryController,
                  CredentialController credentialController,
                  EstablishmentController establishmentController,
                  InformationAboutOwnerController informationAboutOwnerController,
                  ReviewOfEstablishmentController reviewOfEstablishmentController,
                  StreetController streetController,
                  TypeOfEstablishmentController typeOfEstablishmentController,
                  UserAccountController userAccountController) {
        this.cityController = cityController;
        this.countryController = countryController;
        this.credentialController = credentialController;
        this.establishmentController = establishmentController;
        this.informationAboutOwnerController = informationAboutOwnerController;
        this.reviewOfEstablishmentController = reviewOfEstablishmentController;
        this.streetController = streetController;
        this.typeOfEstablishmentController = typeOfEstablishmentController;
        this.userAccountController = userAccountController;

        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: City");
        menu.put("11", "  11 - Create City");
        menu.put("12", "  12 - Update City");
        menu.put("13", "  13 - Delete from City");
        menu.put("14", "  14 - Find all Cities");
        menu.put("15", "  15 - Find City by ID");
        menu.put("16", "  16 - Find City by name");

        menu.put("2", "   2 - Table: Country");
        menu.put("21", "  21 - Create Country");
        menu.put("22", "  22 - Update Country");
        menu.put("23", "  23 - Delete from Country");
        menu.put("24", "  24 - Find all Countries");
        menu.put("25", "  25 - Find City by name");

        menu.put("3", "   3 - Table: Credential");
        menu.put("31", "  31 - Create Credential");
        menu.put("32", "  32 - Update Credential");
        menu.put("33", "  33 - Delete from Credential");
        menu.put("34", "  34 - Find all Credentials");
        menu.put("35", "  35 - Find City by ID");

        menu.put("4", "   4 - Table: Establishment");
        menu.put("41", "  41 - Create Establishment");
        menu.put("42", "  42 - Update Establishment");
        menu.put("43", "  43 - Delete from Establishment");
        menu.put("44", "  44 - Find all Establishments");
        menu.put("45", "  45 - Find Establishment by ID");
        menu.put("46", "  46 - Find Establishment by name");

        menu.put("5", "   5 - Table: InformationAboutOwner");
        menu.put("51", "  51 - Create InformationAboutOwner");
        menu.put("52", "  52 - Update InformationAboutOwner");
        menu.put("53", "  53 - Delete from InformationAboutOwner");
        menu.put("54", "  54 - Find all InformationAboutOwners");
        menu.put("55", "  55 - Find InformationAboutOwner by ID");
        menu.put("56", "  56 - Find InformationAboutOwner by name");

        menu.put("6", "   6 - Table: ReviewOfEstablishment");
        menu.put("61", "  61 - Create ReviewOfEstablishment");
        menu.put("62", "  62 - Update ReviewOfEstablishment");
        menu.put("63", "  63 - Delete from ReviewOfEstablishment");
        menu.put("64", "  64 - Find all ReviewOfEstablishments");
        menu.put("65", "  65 - Find ReviewOfEstablishment by ID");

        menu.put("7", "   7 - Table: Street");
        menu.put("71", "  71 - Create Street");
        menu.put("72", "  72 - Update Street");
        menu.put("73", "  73 - Delete from Street");
        menu.put("74", "  74 - Find all Streets");
        menu.put("75", "  75 - Find Street by ID");
        menu.put("76", "  76 - Find Street by name");

        menu.put("8", "   8 - Table: TypeOfEstablishment");
        menu.put("81", "  81 - Create TypeOfEstablishment");
        menu.put("82", "  82 - Update TypeOfEstablishment");
        menu.put("83", "  83 - Delete from TypeOfEstablishment");
        menu.put("84", "  84 - Find all TypeOfEstablishments");
        menu.put("85", "  85 - Find TypeOfEstablishment by ID");

        menu.put("9", "   9 - Table: UserAccount");
        menu.put("91", "  91 - Create UserAccount");
        menu.put("92", "  92 - Update UserAccount");
        menu.put("93", "  93 - Delete from UserAccount");
        menu.put("94", "  94 - Find all UserAccounts");
        menu.put("95", "  95 - Find UserAccount by nickname");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createCity);
        methodsMenu.put("12", this::updateCity);
        methodsMenu.put("13", this::deleteFromCity);
        methodsMenu.put("14", this::findAllCities);
        methodsMenu.put("15", this::findCityById);
        methodsMenu.put("16", this::findCityByName);

        methodsMenu.put("21", this::createCountry);
        methodsMenu.put("22", this::updateCountry);
        methodsMenu.put("23", this::deleteFromCountry);
        methodsMenu.put("24", this::findAllCountries);
        methodsMenu.put("25", this::findCountryByName);

        methodsMenu.put("31", this::createCredential);
        methodsMenu.put("32", this::updateCredential);
        methodsMenu.put("33", this::deleteFromCredential);
        methodsMenu.put("34", this::findAllCredentials);
        methodsMenu.put("35", this::findCredentialById);

        methodsMenu.put("41", this::createEstablishment);
        methodsMenu.put("42", this::updateEstablishment);
        methodsMenu.put("43", this::deleteFromEstablishment);
        methodsMenu.put("44", this::findAllEstablishments);
        methodsMenu.put("45", this::findEstablishmentById);
        methodsMenu.put("46", this::findEstablishmentByName);

        methodsMenu.put("51", this::createInformationAboutOwner);
        methodsMenu.put("52", this::updateInformationAboutOwner);
        methodsMenu.put("53", this::deleteFromInformationAboutOwner);
        methodsMenu.put("54", this::findAllInformationAboutOwners);
        methodsMenu.put("55", this::findInformationAboutOwnerById);
        methodsMenu.put("56", this::findInformationAboutOwnerByName);

        methodsMenu.put("61", this::createReviewOfEstablishment);
        methodsMenu.put("62", this::updateReviewOfEstablishment);
        methodsMenu.put("63", this::deleteFromReviewOfEstablishment);
        methodsMenu.put("64", this::findAllReviewOfEstablishments);
        methodsMenu.put("65", this::findReviewOfEstablishmentById);

        methodsMenu.put("71", this::createStreet);
        methodsMenu.put("72", this::updateStreet);
        methodsMenu.put("73", this::deleteFromStreet);
        methodsMenu.put("74", this::findAllStreets);
        methodsMenu.put("75", this::findStreetById);
        methodsMenu.put("76", this::findStreetByName);

        methodsMenu.put("81", this::createTypeOfEstablishment);
        methodsMenu.put("82", this::updateTypeOfEstablishment);
        methodsMenu.put("83", this::deleteFromTypeOfEstablishment);
        methodsMenu.put("84", this::findAllTypeOfEstablishments);
        methodsMenu.put("85", this::findTypeOfEstablishmentById);

        methodsMenu.put("91", this::createUserAccount);
        methodsMenu.put("92", this::updateUserAccount);
        methodsMenu.put("93", this::deleteFromUserAccount);
        methodsMenu.put("94", this::findAllUserAccounts);
        methodsMenu.put("95", this::findUserAccountByNickname);
    }

    private void selectAllTable() {
        findAllCities();
        findAllCountries();
        findAllCredentials();
        findAllEstablishments();
        findAllInformationAboutOwners();
        findAllReviewOfEstablishments();
        findAllStreets();
        findAllTypeOfEstablishments();
        findAllUserAccounts();
    }

    // region CITY ---------------------------------------------------
    private void createCity() {
        System.out.println("Input 'city_name': ");
        String cityName = input.nextLine();
        System.out.println("Input 'country': ");
        String country = input.nextLine();

        City city = new City(null, cityName, country);

        int count = cityController.create(city);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCity() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'city_name': ");
        String NewCityName = input.nextLine();
        System.out.println("Input 'country': ");
        String NewCountry = input.nextLine();

        City city = new City(null, NewCityName, NewCountry);

        int count = cityController.update(id, city);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCity() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = cityController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCities() {
        System.out.println("\nTable: CITY");
        List<City> cities = cityController.findAll();
        for (City city : cities) {
            System.out.println(city);
        }
    }

    private void findCityById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<City> city = cityController.findById(id);
        System.out.println(city.orElse(nullCity));
    }

    private void findCityByName() {
        System.out.println("Input 'city_name': ");
        String cityName = input.nextLine();

        Optional<City> book = cityController.findByName(cityName);
        System.out.println(book.orElse(nullCity));
    }

    // region COUNTRY ---------------------------------------------------
    private void createCountry() {
        System.out.println("Input 'country_name': ");
        String countryName = input.nextLine();

        Country country = new Country(countryName);

        int count = countryController.create(country);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCountry() {
        System.out.println("Input 'country_name': ");
        String cityName = input.nextLine();
        System.out.println("Input new 'country_name': ");
        String newCountryName = input.nextLine();

        Country city = new Country(newCountryName);

        int count = countryController.update(cityName, city);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCountry() {
        System.out.println("Input 'country_name': ");
        String countryName = input.nextLine();

        int count = countryController.delete(countryName);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCountries() {
        System.out.println("\nTable: COUNTRY");
        List<Country> countries = countryController.findAll();
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    private void findCountryByName() {
        System.out.println("Input 'country_name': ");
        String countryName = input.nextLine();

        Optional<Country> country = countryController.findById(countryName);
        System.out.println(country.orElse(nullCountry));
    }

    // region CREDENTIAL --------------------------------------------
    private void createCredential() {
        System.out.println("Input 'login': ");
        String loginCredential = input.nextLine();

        System.out.println("Input 'password': ");
        String passwordCredential = input.nextLine();

        Credential credential = new Credential(null, loginCredential, passwordCredential);

        int count = credentialController.create(credential);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCredential() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'login': ");
        String loginCredential = input.nextLine();

        System.out.println("Input 'credential': ");
        String passwordCredential = input.nextLine();

        Credential credential = new Credential(null, loginCredential, passwordCredential);

        int count = credentialController.update(id, credential);
        System.out.printf("There are update %d rows\n", count);
    }

    private void deleteFromCredential() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = credentialController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCredentials() {
        System.out.println("\nTable: CREDENTIAL");
        List<Credential> credentials = credentialController.findAll();
        for (Credential credential : credentials) {
            System.out.println(credential);
        }
    }

    private void findCredentialById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Credential> credential = credentialController.findById(id);
        System.out.println(credential.orElse(nullCredential));
    }

    // region ESTABLISHMENT ---------------------------------------------------
    private void createEstablishment() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        System.out.println("Input 'type_of_establishment': ");
        Integer typeOfEstablishmentId = Integer.valueOf((input.nextInt()));

        System.out.println("Input 'rating': ");
        float rating = input.nextFloat();

        System.out.println("Input 'street_id': ");
        Integer streetId = Integer.valueOf((input.nextInt()));

        System.out.println("Input 'information_about_owner_id': ");
        Integer informationAboutOwnerId = Integer.valueOf((input.nextInt()));

        Establishment establishment = new Establishment(null, name, typeOfEstablishmentId, rating, streetId, informationAboutOwnerId);

        int count = establishmentController.create(establishment);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateEstablishment() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'name': ");
        String name = input.nextLine();

        System.out.println("Input 'type_of_establishment': ");
        Integer typeOfEstablishmentId = Integer.valueOf((input.nextInt()));

        System.out.println("Input 'rating': ");
        float rating = input.nextFloat();

        System.out.println("Input 'street_id': ");
        Integer streetId = Integer.valueOf((input.nextInt()));

        System.out.println("Input 'information_about_owner_id': ");
        Integer informationAboutOwnerId = Integer.valueOf((input.nextInt()));

        Establishment establishment = new Establishment(null, name, typeOfEstablishmentId, rating, streetId, informationAboutOwnerId);

        int count = establishmentController.update(id, establishment);
        System.out.printf("There are update %d rows\n", count);
    }

    private void deleteFromEstablishment() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = establishmentController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllEstablishments() {
        System.out.println("\nTable: ESTABLISHMENT");
        List<Establishment> establishments = establishmentController.findAll();
        for (Establishment establishment : establishments) {
            System.out.println(establishment);
        }
    }

    private void findEstablishmentById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Establishment> establishment = establishmentController.findById(id);
        System.out.println(establishment.orElse(nullEstablishment));
    }

    private void findEstablishmentByName() {
        System.out.println("Input 'name': ");
        String establishmentName = input.nextLine();

        Optional<Establishment> establishment = establishmentController.findByName(establishmentName);
        System.out.println(establishment.orElse(nullEstablishment));
    }

    // region INFORMATION_ABOUT_OWNER
    private void createInformationAboutOwner() {
        System.out.println("Input 'name': ");
        String nameOwner = input.nextLine();

        System.out.println("Input 'surname': ");
        String surnameOnwer = input.nextLine();

        System.out.println("Input 'age': ");
        Integer rating = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'fortunes': ");
        Integer fortunes = Integer.valueOf((input.nextLine()));

        InformationAboutOwner informationAboutOwner = new InformationAboutOwner(null, nameOwner, surnameOnwer, rating, fortunes);

        int count = informationAboutOwnerController.create(informationAboutOwner);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateInformationAboutOwner() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        System.out.println("Input 'name': ");
        String nameOwner = input.nextLine();

        System.out.println("Input 'surname': ");
        String surnameOnwer = input.nextLine();

        System.out.println("Input 'age': ");
        Integer rating = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'fortunes': ");
        Integer fortunes = Integer.valueOf((input.nextLine()));

        InformationAboutOwner informationAboutOwner = new InformationAboutOwner(null, nameOwner, surnameOnwer, rating, fortunes);

        int count = informationAboutOwnerController.update(id, informationAboutOwner);
        System.out.printf("There are update %d rows\n", count);
    }

    private void deleteFromInformationAboutOwner() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = informationAboutOwnerController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllInformationAboutOwners() {
        System.out.println("\nTable: INFORMATION_ABOUT_OWNER");
        List<InformationAboutOwner> informationAboutOwners = informationAboutOwnerController.findAll();
        for (InformationAboutOwner informationAboutOwner : informationAboutOwners) {
            System.out.println(informationAboutOwner);
        }
    }

    private void findInformationAboutOwnerById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<InformationAboutOwner> informationAboutOwner = informationAboutOwnerController.findById(id);
        System.out.println(informationAboutOwner.orElse(nullInformationAboutOwner));
    }

    private void findInformationAboutOwnerByName() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Optional<InformationAboutOwner> informationAboutOwner = informationAboutOwnerController.findByName(name);
        System.out.println(informationAboutOwner.orElse(nullInformationAboutOwner));
    }

    // region REVIEW_OF_ESTABLISHMENT ----------------------------------------
    private void createReviewOfEstablishment() {
        System.out.println("Input 'review': ");
        String review = input.nextLine();

        System.out.println("Input 'user_account_nickname': ");
        String nickname = input.nextLine();

        ReviewOfEstablishment reviewOfEstablishment = new ReviewOfEstablishment(null, review, nickname);

        int count = reviewOfEstablishmentController.create(reviewOfEstablishment);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateReviewOfEstablishment() {
        System.out.printf("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        System.out.println("Input 'review': ");
        String review = input.nextLine();

        System.out.println("Input 'user_account_nickname': ");
        String nickname = input.nextLine();

        ReviewOfEstablishment reviewOfEstablishment = new ReviewOfEstablishment(null, review, nickname);

        int count = reviewOfEstablishmentController.update(id, reviewOfEstablishment);
        System.out.printf("There are update %d rows\n", count);
    }

    private void deleteFromReviewOfEstablishment() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = reviewOfEstablishmentController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllReviewOfEstablishments() {
        System.out.println("\nTable: REVIEW_OF_ESTABLISHMENT");
        List<ReviewOfEstablishment> reviewOfEstablishments = reviewOfEstablishmentController.findAll();
        for (ReviewOfEstablishment reviewOfEstablishment : reviewOfEstablishments) {
            System.out.println(reviewOfEstablishment);
        }
    }

    private void findReviewOfEstablishmentById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<ReviewOfEstablishment> reviewOfEstablishment = reviewOfEstablishmentController.findById(id);
        System.out.println(reviewOfEstablishment.orElse(nullReviewOfEstablishment));
    }

    // region STREET
    private void createStreet() {
        System.out.println("Input 'street_name': ");
        String name = input.nextLine();

        System.out.println("Input 'city_id': ");
        Integer cityId = Integer.valueOf(input.nextLine());

        Street street = new Street(null, name, cityId);

        int count = streetController.create(street);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateStreet() {
        System.out.printf("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        System.out.println("Input 'street_name': ");
        String name = input.nextLine();

        System.out.println("Input 'city_id': ");
        Integer cityId = Integer.valueOf(input.nextLine());

        Street street = new Street(null, name, cityId);

        int count = streetController.update(id, street);
        System.out.printf("There are update %d rows\n", count);
    }

    private void deleteFromStreet() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = streetController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllStreets() {
        System.out.println("\nTable: STREET");
        List<Street> streets = streetController.findAll();
        for (Street street : streets) {
            System.out.println(street);
        }
    }

    private void findStreetById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Street> street = streetController.findById(id);
        System.out.println(street.orElse(nullStreet));
    }

    private void findStreetByName() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Optional<Street> street = streetController.findByName(name);
        System.out.println(street.orElse(nullStreet));
    }

    // region TYPE_OF_ESTABLISHMENT
    private void createTypeOfEstablishment() {
        System.out.println("Input 'type_name': ");
        String nameType = input.nextLine();

        TypeOfEstablishment typeOfEstablishment = new TypeOfEstablishment(null, nameType);
        int count = typeOfEstablishmentController.create(typeOfEstablishment);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateTypeOfEstablishment() {
        System.out.printf("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        System.out.println("Input 'type_name': ");
        String nameType = input.nextLine();

        TypeOfEstablishment typeOfEstablishment = new TypeOfEstablishment(null, nameType);

        int count = typeOfEstablishmentController.update(id, typeOfEstablishment);
        System.out.printf("There are update %d rows\n", count);
    }

    private void deleteFromTypeOfEstablishment() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = typeOfEstablishmentController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllTypeOfEstablishments() {
        System.out.println("\nTable: TYPE_OF_ESTABLISHMENT");
        List<TypeOfEstablishment> typeOfEstablishments = typeOfEstablishmentController.findAll();
        for (TypeOfEstablishment typeOfEstablishment : typeOfEstablishments) {
            System.out.println(typeOfEstablishment);
        }
    }

    private void findTypeOfEstablishmentById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<TypeOfEstablishment> typeOfEstablishment = typeOfEstablishmentController.findById(id);
        System.out.println(typeOfEstablishment.orElse(nullTypeOfEstablishment));
    }

    // region USER_ACCOUNT
    private void createUserAccount() {
        System.out.println("Input 'nickname': ");
        String nickname = input.nextLine();

        System.out.println("Input 'name': ");
        String name = input.nextLine();

        System.out.println("Input 'surname': ");
        String surname = input.nextLine();

        System.out.println("Input 'credential_id': ");
        Integer credentialId = Integer.valueOf(input.nextLine());

        UserAccount userAccount = new UserAccount(nickname, name, surname, credentialId);
        int count = userAccountController.create(userAccount);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateUserAccount() {
        System.out.println("Input 'nickname': ");
        String nickname = input.nextLine();

        System.out.println("Input 'name': ");
        String name = input.nextLine();

        System.out.println("Input 'surname': ");
        String surname = input.nextLine();

        System.out.println("Input 'credential_id': ");
        Integer credentialId = Integer.valueOf(input.nextLine());

        UserAccount userAccount = new UserAccount(null, name, surname, credentialId);
        int count = userAccountController.update(nickname, userAccount);
        System.out.printf("There are update %d rows\n", count);
    }

    private void deleteFromUserAccount() {
        System.out.println("Input 'nickname': ");
        String nickname = input.nextLine();

        int count = userAccountController.delete(nickname);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllUserAccounts() {
        System.out.println("\nTable: USER_ACCOUNT");
        List<UserAccount> userAccounts = userAccountController.findAll();
        for (UserAccount userAccount : userAccounts) {
            System.out.println(userAccount);
        }
    }

    private void findUserAccountByNickname() {
        System.out.println("Input 'nickname': ");
        String nickname = (input.nextLine());

        Optional<UserAccount> userAccount = userAccountController.findById(nickname);
        System.out.println(userAccount.orElse(nullUserAccount));
    }

    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }
}

