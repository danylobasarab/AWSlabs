public class о {
    private static int countPaths(int W, int H, char[][] corridor) {

        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W ; j++) {
                if (corridor[i][j]== corridor[0][W-1] || corridor[i][j]== corridor[H-1][W-1]) {
                    count++;
                }

                return 0;
            }}
    }
}



        for column in modified_input:
        element_index = 0
        for element in column:
        if element:
        alphabetic_dict[element][column_index] += 1
        if column_index > 0 and element != modified_input[column_index - 1][element_index]:
        matching_nghbr[element][column_index] += 1
        alphabetic_dict[element][column_index] *= alphabetic_dict[modified_input[column_index - 1][element_index]][column_index - 1]
        element_index += 1
        for element in set(column):
        if element and column_index > 0:
        if sum((alphabetic_dict[element])[:column_index]) != 0:
        alphabetic_dict[element][column_index] *= sum((alphabetic_dict[element])[:column_index])
        alphabetic_dict[element][column_index] += matching_nghbr[element][column_index]
        column_index += 1
        return alphabetic_dict

