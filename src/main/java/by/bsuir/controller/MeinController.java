package by.bsuir.controller;

import by.bsuir.logic.Manipulations;
import by.bsuir.additional.MyFunctional;

import org.apache.log4j.Logger;
import org.json.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static by.bsuir.Constants.*;

@RestController
public class MeinController {
	private static final Logger logger = Logger.getLogger(MeinController.class);

	//5 laboratory
	@PostMapping(value = "/checkIsIsosceles")
	public String isIsosceles(@RequestBody String message) {
		logger.info(REQUEST_INFO + message);

		JSONObject request = new JSONObject(message);
		String currentStr;

		if(Manipulations.getInstance()
						.isIsoscelesTriangle(request.getInt(KEY_SIDE_1),
						request.getInt(KEY_SIDE_2), request.getInt(KEY_SIDE_3))) {

			currentStr =  IS_ISOSCELES;
		}
		else currentStr = IS_NOT_ISOSCELES;

		logger.info(RESPONSE_INFO + currentStr);
		return message + "\n" + RESULT_INFO + currentStr;
	}

	@PostMapping(value = "/checkIsEquilateral")
	public String isEquilateral(@RequestBody String message) {
		logger.info(REQUEST_INFO + message);

		JSONObject request = new JSONObject(message);
		String currentStr;

		if(Manipulations.getInstance()
				.isEquilateralTriangle(request.getInt(KEY_SIDE_1),
						request.getInt(KEY_SIDE_2), request.getInt(KEY_SIDE_3))) {

			currentStr =  IS_EQUILATERAL;
		}
		else currentStr = IS_NOT_EQUILATERAL;

		logger.info(RESPONSE_INFO + currentStr);
		return message + "\n" + RESULT_INFO + currentStr;
	}


	@PostMapping(value = "/checkIsRight")
	public String isRight(@RequestBody String message) {
		logger.info(REQUEST_INFO + message);

		JSONObject request = new JSONObject(message);
		String currentStr;

		if(Manipulations.getInstance()
				.isRightTriangle(request.getInt(KEY_SIDE_1),
						request.getInt(KEY_SIDE_2), request.getInt(KEY_SIDE_3))) {

			currentStr =  IS_RIGHT;
		}
		else currentStr = IS_NOT_RIGHT;

		logger.info(RESPONSE_INFO + currentStr);
		return message + "\n" + RESULT_INFO + currentStr;
	}

	@PostMapping(value = "/checkTheNumbers")
	public String getNumbers(@RequestBody String message) {
		logger.info(REQUEST_INFO + message);

		JSONObject current = new JSONObject(message);
		List<Integer> listOfNumbers = new ArrayList<>();

		listOfNumbers.add(current.getInt(KEY_SIDE_1));
		listOfNumbers.add(current.getInt(KEY_SIDE_2));
		listOfNumbers.add(current.getInt(KEY_SIDE_3));

		return "\nTheBiggestElement: " + listOfNumbers.stream()
				.max(Comparator.naturalOrder())
				.get().toString() + "\nTheSmallestElement: " + listOfNumbers.stream()
				.min(Comparator.naturalOrder())
				.get().toString();
	}

	//additional task #1 (lab 5)
	@PostMapping(value = "/averageNumber")
	public String getAverageNumber(@RequestBody String stringNumbers) {
		logger.info(REQUEST_INFO + stringNumbers);

		List<Integer> listOfNumbers = new ArrayList<>();
		JSONObject current = new JSONObject(stringNumbers);

		listOfNumbers.add(current.getInt(KEY_SIDE_1));
		listOfNumbers.add(current.getInt(KEY_SIDE_2));
		listOfNumbers.add(current.getInt(KEY_SIDE_3));

		OptionalDouble averageNumber = listOfNumbers.stream().mapToInt(e -> e).average();

		if(averageNumber.isPresent()) {
			return "Average number is: " + averageNumber.getAsDouble();
		}

		return "Smth wrong!";
	}

	//additional task #2 (lab 5)
	@PostMapping(value = "/averageNumber2")
	public double getAverageNumber(@RequestBody List<Integer> numbers) {
		return numbers.stream().mapToDouble(e -> e).average().getAsDouble();
	}

	//additional task #3 (lab 5)
	@PostMapping(value = "/binaryNumber")
	public String getBinaryNumber(@RequestBody String stringNumbers) {
		JSONObject current = new JSONObject(stringNumbers);

		int side1 = current.getInt(KEY_SIDE_1);
		int side2 = current.getInt(KEY_SIDE_2);
		int side3 = current.getInt(KEY_SIDE_3);


		return "Side 1: " + Integer.toBinaryString(side1) + "\n" +
				"Side 2: " + Integer.toBinaryString(side2) + "\n" +
				"Side 3: " + Integer.toBinaryString(side3);
	}

	//Laboratory 6
	//Part #1
	@PostMapping(value = "/positiveSum")
	public int getPositiveSum(@RequestBody int[] message) {
		return Arrays.stream(message).filter(v -> v >= 0).sum();
	}

	//Part #2
	@PostMapping(value = "/preLastNumber")
	public int getPreLastNumber(@RequestBody List<Integer> message) {
		try {
			return message.get(message.size() - 2);
		} catch (ArrayIndexOutOfBoundsException ex) {
			return -9999999;
		}
	}

	//Part #3
	@PostMapping(value = "/binaryNumberIsHere")
	public List<Integer> getBinaryNumberNew(@RequestBody List<Integer> numbers) {

		List<Integer> resultList = new ArrayList<>();

		for(Integer element : numbers) {
			MyFunctional convertToBinary = (number) -> {
				int mod, bin = 0;

				while (number != 0) {
					mod = number % 2;
					number /= 2;

					bin = 10*bin+mod;
				}
				return bin;
			};

			resultList.add(convertToBinary.convert(element));
		}

		return resultList;
	}

}
