package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String ERROR_MESSAGE_NUMBER_SIZE = LOTTO_NUMBER_SIZE + "개의 번호를 입력해주세요.";
    private static final String ERROR_MESSAGE_NOT_UNIQUE = "중복되는 번호가 존재합니다.";

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String input) {
        validate(input);
        List<String> lottoNumberList = Arrays.asList(input.split(LOTTO_NUMBER_DELIMITER));
        this.lottoNumbers = mapLottoNumbers(lottoNumberList);
    }

    private List<LottoNumber> mapLottoNumbers(List<String> lottoNumberList) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : lottoNumberList) {
            LottoNumber lottoNumber = new LottoNumber(number);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private void validate(String input) {
        validateNullOrEmpty(input);
        validateSize(input);
        validateUnique(input);
    }

    private void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_SIZE);
        }
    }

    private void validateSize(String input) {
        if (input.split(LOTTO_NUMBER_DELIMITER).length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_SIZE);
        }
    }

    private void validateUnique(String input) {
        List<String> lottoNumberList = Arrays.asList(input.split(LOTTO_NUMBER_DELIMITER));
        HashSet<String> distinctLottoNumberList = new HashSet<>(lottoNumberList);
        if (lottoNumberList.size() != distinctLottoNumberList.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_UNIQUE);
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
