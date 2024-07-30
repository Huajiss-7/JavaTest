package leetcode;

public class 检查操作是否合法 {
    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'W', 'B', 'B', '.', 'W', 'W', 'W', 'B'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'}};

        char[][] matrix = {
                {'.', '.', 'W', '.', 'B', 'W', 'W', 'B'},
                {'B', 'W', '.', 'W', '.', 'W', 'B', 'B'},
                {'.', 'W', 'B', 'W', 'W', '.', 'W', 'W'},
                {'W', 'W', '.', 'W', '.', '.', 'B', 'B'},
                {'B', 'W', 'B', 'B', 'W', 'W', 'B', '.'},
                {'W', '.', 'W', '.', 'A', 'B', 'W', 'W'},
                {'B', '.', 'B', 'B', '.', '.', 'B', 'B'},
                {'.', 'W', '.', 'W', '.', 'W', '.', 'W'}
        };
        System.out.println(checkMove(matrix, 5, 4, 'W'));

        System.out.println(checkMove(board, 4, 3, 'B'));
    }

    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int m = board.length;
        int n = board[0].length;
        boolean continue1 = true;
        boolean continue2 = true;
        boolean continue3 = true;
        boolean continue4 = true;
        boolean continue5 = true;
        boolean continue6 = true;
        boolean continue7 = true;
        boolean continue8 = true;
        int point1 = rMove;//左
        int point2 = cMove;
        int point3 = rMove;//右
        int point4 = cMove;
        int point5 = rMove;//上
        int point6 = cMove;
        int point7 = rMove;//下
        int point8 = cMove;
        int point9 = rMove;//左上
        int point10 = cMove;
        int point11 = rMove;//左下
        int point12 = cMove;
        int point13 = rMove;//右上
        int point14 = cMove;
        int point15 = rMove;//右下
        int point16 = cMove;
        if(point2 <= 0)continue1=false;
        if(point4 >= n - 1)continue2=false;
        if(point5 <= 0)continue3=false;
        if(point7>= m-1)continue4=false;
        if(!(point9 > 0&&point10>0))continue5=false;
        if(!(point11 < m - 1 && point12 > 0))continue6=false;
        if(!(point13 > 0 && point14 < n - 1))continue7=false;
        if(!(point15 < m - 1 && point16 < n - 1))continue8=false;
        while (true) {
            //左
            if (point2 > 0 && continue1) {
                if (color == 'B') {
                    point2--;
                    if (point2 == cMove - 1) {
                        if (board[point1][point2] != 'W') {
                            continue1 = false;
                        }
                    } else if (board[point1][point2] != 'W' && board[point1][point2] != 'B') {
                        continue1 = false;
                    } else if (board[point1][point2] == 'B') {
                        return true;
                    }
                } else {
                    point2--;
                    if (point2 == cMove - 1) {
                        if (board[point1][point2] != 'B') {
                            continue1 = false;
                        }
                    } else if (board[point1][point2] != 'W' && board[point1][point2] != 'B') {
                        continue1 = false;
                    } else if (board[point1][point2] == 'W') {
                        return true;
                    }
                }
            }else continue1=false;
            //右
            if (point4 < n - 1 && continue2) {
                if (color == 'B') {
                    point4++;
                    if (point4 == cMove + 1) {
                        if (board[point3][point4] != 'W') {
                            continue2 = false;
                        }
                    } else if (board[point3][point4] != 'W' && board[point3][point4] != 'B') {
                        continue2 = false;
                    } else if (board[point3][point4] == 'B') {
                        return true;
                    }
                } else {
                    point4++;
                    if (point4 == cMove + 1) {
                        if (board[point3][point4] != 'B') {
                            continue2 = false;
                        }
                    } else if (board[point3][point4] != 'W' && board[point3][point4] != 'B') {
                        continue2 = false;
                    } else if (board[point3][point4] == 'W') {
                        return true;
                    }
                }
            }else continue2=false;
            //上
            if (point5 > 0 && continue3) {
                if (color == 'B') {
                    point5--;
                    if (point5 == rMove - 1) {
                        if (board[point5][point6] != 'W') {
                            continue3 = false;
                        }
                    } else if (board[point5][point6] != 'W' && board[point5][point6] != 'B') {
                        continue3 = false;
                    } else if (board[point5][point6] == 'B') {
                        return true;
                    }
                } else {
                    point5--;
                    if (point5 == rMove - 1) {
                        if (board[point5][point6] != 'B') {
                            continue3 = false;
                        }
                    } else if (board[point5][point6] != 'W' && board[point5][point6] != 'B') {
                        continue3 = false;
                    } else if (board[point5][point6] == 'W') {
                        return true;
                    }
                }
            }else continue3=false;
            //下
            if (point7 < m - 1 && continue4) {
                if (color == 'B') {
                    point7++;
                    if (point7 == rMove + 1) {
                        if (board[point7][point8] != 'W') {
                            continue4 = false;
                        }
                    }else if(board[point7][point8]!='W'&&board[point7][point8]!='B'){
                        continue4=false;
                    }
                    else if (board[point7][point8] == 'B') {
                        return true;
                    }
                } else {
                    point7++;
                    if (point7 == rMove + 1) {
                        if (board[point7][point8] != 'B') {
                            continue4 = false;
                        }
                    }else if(board[point7][point8]!='W'&&board[point7][point8]!='B'){
                        continue4=false;
                    }
                    else if (board[point7][point8] == 'W') {
                        return true;
                    }
                }
            }else continue4=false;
            //左上
            if (point9 > 0&&point10>0 && continue5) {
                if (color == 'B') {
                    point9--;
                    point10--;
                    if (point9 == rMove - 1) {
                        if (board[point9][point10] != 'W') {
                            continue5 = false;
                        }
                    }else if(board[point9][point10]!='W'&&board[point9][point10]!='B'){
                        continue5=false;
                    }
                    else if (board[point9][point10] == 'B') {
                        return true;
                    }
                } else {
                    point9--;
                    point10--;
                    if (point9 == rMove - 1) {
                        if (board[point9][point10] != 'B') {
                            continue5 = false;
                        }
                    }else if(board[point9][point10]!='W'&&board[point9][point10]!='B'){
                        continue5=false;
                    }
                    else if (board[point9][point10] == 'W') {
                        return true;
                    }
                }
            }else continue5=false;
            // 左下
            if (point11 < m - 1 && point12 > 0 && continue6) {
                point11++;
                point12--;
                if (point11 == rMove + 1) {
                    if (board[point11][point12] != (color == 'B' ? 'W' : 'B')) {
                        continue6 = false;
                    }
                } else if (board[point11][point12] != 'W' && board[point11][point12] != 'B') {
                    continue6 = false;
                } else if (board[point11][point12] == color) {
                    return true;
                }
            }else continue6=false;

            // 右上
            if (point13 > 0 && point14 < n - 1 && continue7) {
                point13--;
                point14++;
                if (point13 == rMove - 1) {
                    if (board[point13][point14] != (color == 'B' ? 'W' : 'B')) {
                        continue7 = false;
                    }
                } else if (board[point13][point14] != 'W' && board[point13][point14] != 'B') {
                    continue7 = false;
                } else if (board[point13][point14] == color) {
                    return true;
                }
            }else continue7=false;

            // 右下
            if (point15 < m - 1 && point16 < n - 1 && continue8) {
                point15++;
                point16++;
                if (point15 == rMove + 1) {
                    if (board[point15][point16] != (color == 'B' ? 'W' : 'B')) {
                        continue8 = false;
                    }
                } else if (board[point15][point16] != 'W' && board[point15][point16] != 'B') {
                    continue8 = false;
                } else if (board[point15][point16] == color) {
                    return true;
                }
            }else continue8=false;

            // 如果所有方向都不再继续，则退出循环
            if (!continue1 && !continue2 && !continue3 && !continue4 &&
                    !continue5 && !continue6 && !continue7 && !continue8) {
                break;
            }
        }
        return false;
    }

    public boolean checkMove1(char[][] board, int rMove, int cMove, char color) {
        // 从 x 轴正方向开始逆时针枚举 8 个方向
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};   // 行改变量
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};   // 列改变量
        for (int k = 0; k < 8; ++k) {
            if (check(board, rMove, cMove, color, dx[k], dy[k])) {
                return true;
            }
        }
        return false;
    }

    // 判断每个方向是否存在以操作位置为起点的好线段
    public boolean check(char[][] board, int rMove, int cMove, char color, int dx, int dy) {
        int x = rMove + dx;
        int y = cMove + dy;
        int step = 1;   // 当前遍历到的节点序号
        while (x >= 0 && x < 8 && y >= 0 && y < 8) {
            if (step == 1) {
                // 第一个点必须为相反颜色
                if (board[x][y] == '.' || board[x][y] == color) {
                    return false;
                }
            } else {
                // 好线段中不应存在空格子
                if (board[x][y] == '.') {
                    return false;
                }
                // 遍历到好线段的终点，返回 true
                if (board[x][y] == color) {
                    return true;
                }
            }
            ++step;
            x += dx;
            y += dy;
        }
        // 不存在符合要求的好线段
        return false;
    }

}

/*给你一个下标从 0 开始的 8 x 8 网格 board ，其中 board[r][c] 表示游戏棋盘上的格子 (r, c) 。棋盘上空格用 '.' 表示，白色格子用 'W' 表示，黑色格子用 'B' 表示。

游戏中每次操作步骤为：选择一个空格子，将它变成你正在执行的颜色（要么白色，要么黑色）。但是，合法 操作必须满足：涂色后这个格子是 好线段的一个端点 （好线段可以是水平的，竖直的或者是对角线）。

好线段 指的是一个包含 三个或者更多格子（包含端点格子）的线段，线段两个端点格子为 同一种颜色 ，且中间剩余格子的颜色都为 另一种颜色 （线段上不能有任何空格子）。你可以在下图找到好线段的例子：


给你两个整数 rMove 和 cMove 以及一个字符 color ，表示你正在执行操作的颜色（白或者黑），如果将格子 (rMove, cMove) 变成颜色 color 后，是一个 合法 操作，那么返回 true ，如果不是合法操作返回 false 。



示例 1：



输入：board = [[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],["W","B","B",".","W","W","W","B"],[".",".",".","B",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".","."]], rMove = 4, cMove = 3, color = "B"
输出：true
解释：'.'，'W' 和 'B' 分别用颜色蓝色，白色和黑色表示。格子 (rMove, cMove) 用 'X' 标记。
以选中格子为端点的两个好线段在上图中用红色矩形标注出来了。
示例 2：



输入：board = [[".",".",".",".",".",".",".","."],[".","B",".",".","W",".",".","."],[".",".","W",".",".",".",".","."],[".",".",".","W","B",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".","B","W",".","."],[".",".",".",".",".",".","W","."],[".",".",".",".",".",".",".","B"]], rMove = 4, cMove = 4, color = "W"
输出：false
解释：虽然选中格子涂色后，棋盘上产生了好线段，但选中格子是作为中间格子，没有产生以选中格子为端点的好线段。*/
