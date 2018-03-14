package com.iu.db3;

import java.util.*;

public class EmpController {
	private Scanner sc;
	private EmpDAO dao;
	private View view;
	private Input input;

	public EmpController() {
		sc = new Scanner(System.in);
		dao = new EmpDAO();
		view = new View();
		input = new Input();
	}

	public void start() throws Exception {

		while (true) {
			System.out.println("1.부서추가|2.전체부서조회|3.종료");
			int select = sc.nextInt();
			EmpDTO	deptDTO = new EmpDTO();

			if (select == 1) {
				
			}

			else if (select == 2) {
				ArrayList<EmpDTO> arrayList=dao.selectALL();
				view.view1(arrayList);
			}

			else {
				break;
			}

		}
		System.out.println("종료");

	}
}
