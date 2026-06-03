class Solution {

    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();
        for(int i=0; i<strs.size(); i++){
            output.append(strs.get(i).length());
            output.append("#");
            output.append(strs.get(i));
        }
        return output.toString();

    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimiter = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimiter));
            i = delimiter + 1;
            output.add(str.substring(i, i + length));
            i += length;
        }
        return output;
    }
}
