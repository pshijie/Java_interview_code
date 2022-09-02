import java.util.BitSet;

/**
 * @author psj
 * @date 2022/8/24 10:02
 * @File: 布隆过滤器.java
 * @Software: IntelliJ IDEA
 */
public class 布隆过滤器 {
    // 位数组大小
    private static final int DEFAULT_SIZE = 2 << 24;
    // 通过这个数组可以创建 6 个不同的哈希函数
    private static final int[] SEEDS = new int[]{3, 12, 2, 111, 24, 33};
    // 位数组：数组中的元素只能是 0 或 1
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    // 存放包含 hash 函数的类的数组
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public 布隆过滤器() {
        // 初始化多个不同的 Hash 函数
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    // 添加元素到位数组
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    // 判断指定元素是否存在于位数组
    public boolean contains(Object value) {
        boolean result = true;
        for (SimpleHash f : func) {
            result = result && bits.get(f.hash(value));
        }
        return result;
    }

    public static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        // 计算hash值
        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }


    public static void main(String[] args) {
        String value1 = "psj";
        String value2 = "psj2";
        布隆过滤器 filter = new 布隆过滤器();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
    }
}
