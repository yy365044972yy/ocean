package com.hb.ocean.utils.pca;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PCAUtils {
	public static String pca="[{\n" +
			"    \"provinceCode\": \"410000\",\n" +
			"    \"provinceName\": \"河南省\",\n" +
			"    \"mallCityList\": [{\n" +
			"        \"cityCode\": \"410100\",\n" +
			"        \"cityName\": \"郑州市\",\n" +
			"        \"mallAreaList\": [{\n" +
			"            \"areaCode\": \"410101\",\n" +
			"            \"areaName\": \"本市区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410102\",\n" +
			"            \"areaName\": \"中原区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410103\",\n" +
			"            \"areaName\": \"二七区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410104\",\n" +
			"            \"areaName\": \"管城回族区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410105\",\n" +
			"            \"areaName\": \"金水区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410106\",\n" +
			"            \"areaName\": \"上街区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410108\",\n" +
			"            \"areaName\": \"惠济区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410109\",\n" +
			"            \"areaName\": \"经济开发区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"412000\",\n" +
			"            \"areaName\": \"航空港区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410122\",\n" +
			"            \"areaName\": \"中牟县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410182\",\n" +
			"            \"areaName\": \"荥阳市\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410183\",\n" +
			"            \"areaName\": \"新密市\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410184\",\n" +
			"            \"areaName\": \"新郑市\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410185\",\n" +
			"            \"areaName\": \"登封市\"\n" +
			"        }]\n" +
			"    }, {\n" +
			"\n" +
			"\n" +
			"        \"cityCode\": \"410200\",\n" +
			"        \"cityName\": \"开封市\",\n" +
			"        \"mallAreaList\": [{\n" +
			"            \"areaCode\": \"410201\",\n" +
			"            \"areaName\": \"本市区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410202\",\n" +
			"            \"areaName\": \"龙亭区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410203\",\n" +
			"            \"areaName\": \"顺河回族区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410204\",\n" +
			"            \"areaName\": \"鼓楼区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410205\",\n" +
			"            \"areaName\": \"禹王台区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410211\",\n" +
			"            \"areaName\": \"金明区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410221\",\n" +
			"            \"areaName\": \"杞县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410222\",\n" +
			"            \"areaName\": \"通许县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410223\",\n" +
			"            \"areaName\": \"尉氏县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410224\",\n" +
			"            \"areaName\": \"开封县\"\n" +
			"        }]\n" +
			"    }, {\n" +
			"\n" +
			"        \"cityCode\": \"410300\",\n" +
			"        \"cityName\": \"洛阳市\",\n" +
			"        \"mallAreaList\": [{\n" +
			"            \"areaCode\": \"410301\",\n" +
			"            \"areaName\": \"本市区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410302\",\n" +
			"            \"areaName\": \"老城区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410303\",\n" +
			"            \"areaName\": \"西工区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410304\",\n" +
			"            \"areaName\": \"瀍河回族区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410305\",\n" +
			"            \"areaName\": \"涧西区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410306\",\n" +
			"            \"areaName\": \"吉利区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410311\",\n" +
			"            \"areaName\": \"洛龙区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410322\",\n" +
			"            \"areaName\": \"孟津县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410323\",\n" +
			"            \"areaName\": \"新安县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410324\",\n" +
			"            \"areaName\": \"栾川县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410325\",\n" +
			"            \"areaName\": \"嵩县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410326\",\n" +
			"            \"areaName\": \"汝阳县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410327\",\n" +
			"            \"areaName\": \"宜阳县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410328\",\n" +
			"            \"areaName\": \"洛宁县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410329\",\n" +
			"            \"areaName\": \"伊川县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410381\",\n" +
			"            \"areaName\": \"偃师市\"\n" +
			"        }]\n" +
			"    }, {\n" +
			"        \"cityCode\": \"410400\",\n" +
			"        \"cityName\": \"平顶山市\",\n" +
			"        \"mallAreaList\": [{\n" +
			"            \"areaCode\": \"410401\",\n" +
			"            \"areaName\": \"本市区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410402\",\n" +
			"            \"areaName\": \"新华区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410403\",\n" +
			"            \"areaName\": \"卫东区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410404\",\n" +
			"            \"areaName\": \"石龙区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410411\",\n" +
			"            \"areaName\": \"湛河区\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410421\",\n" +
			"            \"areaName\": \"宝丰县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410422\",\n" +
			"            \"areaName\": \"叶县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410423\",\n" +
			"            \"areaName\": \"鲁山县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410425\",\n" +
			"            \"areaName\": \"郏县\"\n" +
			"        }, {\n" +
			"            \"areaCode\": \"410481\",\n" +
			"            \"areaName\": \"舞钢市\"\n" +
			"        }]\n" +
			"    },\n" +
			"        {\n" +
			"            \"cityCode\": \"410482\",\n" +
			"            \"cityName\": \"汝州市\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"410482\",\n" +
			"                    \"areaName\": \"汝州市\"\n" +
			"                }\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"\n" +
			"            \"cityCode\": \"410500\",\n" +
			"            \"cityName\": \"安阳市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"410501\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410502\",\n" +
			"                \"areaName\": \"文峰区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410503\",\n" +
			"                \"areaName\": \"北关区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410505\",\n" +
			"                \"areaName\": \"殷都区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410506\",\n" +
			"                \"areaName\": \"龙安区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410522\",\n" +
			"                \"areaName\": \"安阳县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410523\",\n" +
			"                \"areaName\": \"汤阴县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410527\",\n" +
			"                \"areaName\": \"内黄县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410581\",\n" +
			"                \"areaName\": \"林州市\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"            \"cityCode\": \"410600\",\n" +
			"            \"cityName\": \"鹤壁市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"410601\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410602\",\n" +
			"                \"areaName\": \"鹤山区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410603\",\n" +
			"                \"areaName\": \"山城区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410611\",\n" +
			"                \"areaName\": \"淇滨区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410621\",\n" +
			"                \"areaName\": \"浚县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410622\",\n" +
			"                \"areaName\": \"淇县\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"\n" +
			"\n" +
			"            \"cityCode\": \"410700\",\n" +
			"            \"cityName\": \"新乡市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"410701\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410702\",\n" +
			"                \"areaName\": \"红旗区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410703\",\n" +
			"                \"areaName\": \"卫滨区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410704\",\n" +
			"                \"areaName\": \"凤泉区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410711\",\n" +
			"                \"areaName\": \"牧野区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410721\",\n" +
			"                \"areaName\": \"新乡县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410724\",\n" +
			"                \"areaName\": \"获嘉县\"\n" +
			"            }, {\n" +
			"\n" +
			"                \"areaCode\": \"410725\",\n" +
			"                \"areaName\": \"原阳县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410726\",\n" +
			"                \"areaName\": \"延津县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410727\",\n" +
			"                \"areaName\": \"封丘县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410781\",\n" +
			"                \"areaName\": \"卫辉市\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410782\",\n" +
			"                \"areaName\": \"辉县市\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"            \"cityCode\": \"410800\",\n" +
			"            \"cityName\": \"焦作市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"410801\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410802\",\n" +
			"                \"areaName\": \"解放区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410803\",\n" +
			"                \"areaName\": \"中站区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410804\",\n" +
			"                \"areaName\": \"马村区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410811\",\n" +
			"                \"areaName\": \"山阳区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410821\",\n" +
			"                \"areaName\": \"修武县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410822\",\n" +
			"                \"areaName\": \"博爱县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410823\",\n" +
			"                \"areaName\": \"武陟县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410825\",\n" +
			"                \"areaName\": \"温县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410882\",\n" +
			"                \"areaName\": \"沁阳市\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410883\",\n" +
			"                \"areaName\": \"孟州市\"\n" +
			"            }]\n" +
			"        },\n" +
			"\n" +
			"        {\n" +
			"            \"cityCode\": \"410900\",\n" +
			"            \"cityName\": \"濮阳市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"410901\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410902\",\n" +
			"                \"areaName\": \"华龙区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410922\",\n" +
			"                \"areaName\": \"清丰县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410923\",\n" +
			"                \"areaName\": \"南乐县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410926\",\n" +
			"                \"areaName\": \"范县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410927\",\n" +
			"                \"areaName\": \"台前县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"410928\",\n" +
			"                \"areaName\": \"濮阳县\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"\n" +
			"\n" +
			"            \"cityCode\": \"411000\",\n" +
			"            \"cityName\": \"许昌市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"411001\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411002\",\n" +
			"                \"areaName\": \"魏都区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411023\",\n" +
			"                \"areaName\": \"许昌县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411024\",\n" +
			"                \"areaName\": \"鄢陵县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411025\",\n" +
			"                \"areaName\": \"襄城县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411081\",\n" +
			"                \"areaName\": \"禹州市\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411082\",\n" +
			"                \"areaName\": \"长葛市\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"            \"cityCode\": \"411100\",\n" +
			"            \"cityName\": \"漯河市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"411101\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411102\",\n" +
			"                \"areaName\": \"源汇区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411103\",\n" +
			"                \"areaName\": \"郾城区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411104\",\n" +
			"                \"areaName\": \"召陵区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411121\",\n" +
			"                \"areaName\": \"舞阳县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411122\",\n" +
			"                \"areaName\": \"临颍县\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"            \"cityCode\": \"411200\",\n" +
			"            \"cityName\": \"三门峡市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"411201\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411202\",\n" +
			"                \"areaName\": \"湖滨区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411221\",\n" +
			"                \"areaName\": \"渑池县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411222\",\n" +
			"                \"areaName\": \"陕县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411224\",\n" +
			"                \"areaName\": \"卢氏县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411281\",\n" +
			"                \"areaName\": \"义马市\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411282\",\n" +
			"                \"areaName\": \"灵宝市\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"            \"cityCode\": \"411300\",\n" +
			"            \"cityName\": \"南阳市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"411301\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411302\",\n" +
			"                \"areaName\": \"宛城区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411303\",\n" +
			"                \"areaName\": \"卧龙区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411321\",\n" +
			"                \"areaName\": \"南召县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411322\",\n" +
			"                \"areaName\": \"方城县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411323\",\n" +
			"                \"areaName\": \"西峡县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411324\",\n" +
			"                \"areaName\": \"镇平县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411325\",\n" +
			"                \"areaName\": \"内乡县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411326\",\n" +
			"                \"areaName\": \"淅川县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411327\",\n" +
			"                \"areaName\": \"社旗县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411328\",\n" +
			"                \"areaName\": \"唐河县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411329\",\n" +
			"                \"areaName\": \"新野县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411330\",\n" +
			"                \"areaName\": \"桐柏县\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"            \"cityCode\": \"411400\",\n" +
			"            \"cityName\": \"商丘市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"411401\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411402\",\n" +
			"                \"areaName\": \"梁园区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411403\",\n" +
			"                \"areaName\": \"睢阳区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411421\",\n" +
			"                \"areaName\": \"民权县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411422\",\n" +
			"                \"areaName\": \"睢县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411423\",\n" +
			"                \"areaName\": \"宁陵县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411424\",\n" +
			"                \"areaName\": \"柘城县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411425\",\n" +
			"                \"areaName\": \"虞城县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411426\",\n" +
			"                \"areaName\": \"夏邑县\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"            \"cityCode\": \"411500\",\n" +
			"            \"cityName\": \"信阳市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"411501\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411502\",\n" +
			"                \"areaName\": \"浉河区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411503\",\n" +
			"                \"areaName\": \"平桥区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411521\",\n" +
			"                \"areaName\": \"罗山县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411522\",\n" +
			"                \"areaName\": \"光山县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411523\",\n" +
			"                \"areaName\": \"新县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411524\",\n" +
			"                \"areaName\": \"商城县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411526\",\n" +
			"                \"areaName\": \"潢川县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411527\",\n" +
			"                \"areaName\": \"淮滨县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411528\",\n" +
			"                \"areaName\": \"息县\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"            \"cityCode\": \"411600\",\n" +
			"            \"cityName\": \"周口市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"411601\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411602\",\n" +
			"                \"areaName\": \"川汇区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411621\",\n" +
			"                \"areaName\": \"扶沟县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411622\",\n" +
			"                \"areaName\": \"西华县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411623\",\n" +
			"                \"areaName\": \"商水县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411624\",\n" +
			"                \"areaName\": \"沈丘县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411625\",\n" +
			"                \"areaName\": \"郸城县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411626\",\n" +
			"                \"areaName\": \"淮阳县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411627\",\n" +
			"                \"areaName\": \"太康县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411681\",\n" +
			"                \"areaName\": \"项城市\"\n" +
			"            }]\n" +
			"        }, {\n" +
			"\n" +
			"\n" +
			"            \"cityCode\": \"411700\",\n" +
			"            \"cityName\": \"驻马店市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"411701\",\n" +
			"                \"areaName\": \"本市区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411702\",\n" +
			"                \"areaName\": \"驿城区\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411721\",\n" +
			"                \"areaName\": \"西平县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411722\",\n" +
			"                \"areaName\": \"上蔡县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411723\",\n" +
			"                \"areaName\": \"平舆县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411724\",\n" +
			"                \"areaName\": \"正阳县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411725\",\n" +
			"                \"areaName\": \"确山县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411726\",\n" +
			"                \"areaName\": \"泌阳县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411727\",\n" +
			"                \"areaName\": \"汝南县\"\n" +
			"            }, {\n" +
			"                \"areaCode\": \"411728\",\n" +
			"                \"areaName\": \"遂平县\"\n" +
			"            }]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"410181\",\n" +
			"            \"cityName\": \"巩义市\",\n" +
			"            \"mallAreaList\": [{\n" +
			"                \"areaCode\": \"410181\",\n" +
			"                \"areaName\": \"巩义\"\n" +
			"            }\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"410225\",\n" +
			"            \"cityName\": \"兰考县\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"410225\",\n" +
			"                    \"areaName\": \"兰考\"\n" +
			"                }\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"410526\",\n" +
			"            \"cityName\": \"滑县\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"410526\",\n" +
			"                    \"areaName\": \"滑县区\"\n" +
			"                }\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"410728\",\n" +
			"            \"cityName\": \"长垣县\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"410728\",\n" +
			"                    \"areaName\": \"长垣\"\n" +
			"                }\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"411381\",\n" +
			"            \"cityName\": \"邓州市\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"411381\",\n" +
			"                    \"areaName\": \"邓州\"\n" +
			"                }\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"411481\",\n" +
			"            \"cityName\": \"永城市\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"411481\",\n" +
			"                    \"areaName\": \"永城\"\n" +
			"                }\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"411525\",\n" +
			"            \"cityName\": \"固始县\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"411525\",\n" +
			"                    \"areaName\": \"固始\"\n" +
			"                }\n" +
			"\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"411628\",\n" +
			"            \"cityName\": \"鹿邑县\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"411628\",\n" +
			"                    \"areaName\": \"鹿邑\"\n" +
			"                }\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"411729\",\n" +
			"            \"cityName\": \"新蔡县\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"411729\",\n" +
			"                    \"areaName\": \"新蔡\"\n" +
			"                }\n" +
			"            ]\n" +
			"        },\n" +
			"        {\n" +
			"            \"cityCode\": \"419001\",\n" +
			"            \"cityName\": \"济源市\",\n" +
			"            \"mallAreaList\": [\n" +
			"                {\n" +
			"                    \"areaCode\": \"419001\",\n" +
			"                    \"areaName\": \"济源\"\n" +
			"                }\n" +
			"            ]\n" +
			"        }\n" +
			"\n" +
			"\n" +
			"    ]\n" +
			"}]";
	public static List<ProviceList> readValues=null;
	static {
		readValues= JsonUtils.readValues(pca, ProviceList.class);
	}
	public static String findProvinceId(String name) {
		for (int i = 0; i < readValues.size(); i++) {
			if (readValues.get(i).getProvinceName().equals(name)) {
				return readValues.get(i).getProvinceCode()+"_"+readValues.size()+"_"+i;
			}

		}
		return null;
	}
	public static String findCityId(String pName,String cName) {
		for (int i = 0; i < readValues.size(); i++) {
			if (readValues.get(i).getProvinceName().equals(pName)) {
				List<MallCityList> mallCityList = readValues.get(i).getMallCityList();
				for(int j=0;i<mallCityList.size();j++) {
					if (mallCityList.get(j).getCityName().equals(cName)) {
						return mallCityList.get(j).getCityCode()+"_"+mallCityList.size()+"_"+j;
					}
				}
			}

		}
		return null;
	}
	public static String findArea(String pName,String cName,String areaName) {
		for (int i = 0; i < readValues.size(); i++) {
			if (readValues.get(i).getProvinceName().equals(pName)) {
				List<MallCityList> mallCityList = readValues.get(i).getMallCityList();
				for(int j=0;i<mallCityList.size();j++) {
					if (mallCityList.get(j).getCityName().equals(cName)) {
						List<MallAreaList> mallAreaList = mallCityList.get(j).getMallAreaList();
						for(int k=0;k<mallAreaList.size();k++) {
							if(mallAreaList.get(k).getAreaName().equals(areaName)) {
								return mallAreaList.get(k).getAreaCode();
							}
						}
					}
				}
			}

		}
		return null;
	}

	/**
	 * 通过省id查市下id_name
	 * @return
	 */
	public static String findCitysCodeByProvinceId(String pcode) {
		StringBuffer _citysIds = new StringBuffer();
		for (int i = 0; i < readValues.size(); i++) {
			if (!readValues.get(i).getProvinceCode().equals(pcode)) {
				continue;
			}
			List<MallCityList> cityLists = readValues.get(i).getMallCityList();
			for (int j = 0; j < cityLists.size(); j++) {
				_citysIds.append(cityLists.get(j).getCityCode() + "_" + cityLists.get(j).getCityName()+ ",");
			}
		}
		return _citysIds.toString();
	}
	/**
	 * 通过省id查区下id_name
	 * @return
	 */
	public static String findAreaCodeByProvinceId(String pcode) {
		StringBuffer _areaIds = new StringBuffer();
		for (int i = 0; i < readValues.size(); i++) {
			if (!readValues.get(i).getProvinceCode().equals(pcode)) {
				continue;
			}
			List<MallCityList> cityLists = readValues.get(i).getMallCityList();
			for (int j = 0; j < cityLists.size(); j++) {
				List<MallAreaList> mallAreaList = cityLists.get(j).getMallAreaList();
				for(MallAreaList e:mallAreaList) {
					_areaIds.append(e.getAreaCode() + "_" +e.getAreaName()+ ",");
				}

			}
		}
		return _areaIds.toString();
	}
	/**
	 * 通过市code，查市下 区 id_name
	 *
	 * @param pcode
	 * @returns
	 */
	public static String findAreaCodeByCityId(String cityCode) {
		StringBuffer _areaIds = new StringBuffer();
		String proviceCode = cityCode.substring(0, 2) + "0000";
		for (int i = 0; i < readValues.size(); i++) {
			if (!readValues.get(i).getProvinceCode().equals(proviceCode)) {
				continue;
			}
			List<MallCityList> cityLists = readValues.get(i).getMallCityList();
			for (int j = 0; j < cityLists.size(); j++) {
				if (!cityLists.get(j).getCityCode().equals(cityCode)) {
					continue;
				}
				List<MallAreaList> mallAreaList = cityLists.get(j).getMallAreaList();
				for (int g = 0; g < mallAreaList.size(); g++) {
					_areaIds.append(mallAreaList.get(g).getAreaCode() + "_" + mallAreaList.get(g).getAreaName() + ",");
				}
			}
		}
		return _areaIds.toString();

	}




	/**
	 * 获取所有区id_name
	 *
	 */

	public static String selectallareacode_name() {
		StringBuffer _areaIds = new StringBuffer();
		for (int i = 0; i < readValues.size(); i++) {
			List<MallCityList> cityLists = readValues.get(i).getMallCityList();
			for (int j = 0; j < cityLists.size(); j++) {
				List<MallAreaList> mallAreaList = cityLists.get(j).getMallAreaList();

				for(MallAreaList e:mallAreaList) {
					_areaIds.append(e.getAreaCode() + "_" +e.getAreaName()+ ",");
				}

			}

		}
		return _areaIds.toString();


	}
	/**
	 * 根据任意中文返回对应id
	 *
	 */

	public static String getid(String name) {
		for (int i = 0; i < readValues.size(); i++) {

			if(readValues.get(i).getProvinceName().equals(name)) {
				return readValues.get(i).getProvinceCode();
			}

			List<MallCityList> cityLists = readValues.get(i).getMallCityList();
			for (int j = 0; j < cityLists.size(); j++) {

				List<MallAreaList> mallAreaList = cityLists.get(j).getMallAreaList();
				if(cityLists.get(j).getCityName().contains(name)) {
					return cityLists.get(j).getCityCode();
				}

				for(MallAreaList e:mallAreaList) {
					if(e.getAreaName().contains(name)) {
						return e.getAreaCode();
					}
				}

			}

		}
		return null;


	}

	/**
	 * 根据任意对应id返回中文
	 *
	 */

	public static String getname(String id) {
		for (int i = 0; i < readValues.size(); i++) {

			if(readValues.get(i).getProvinceCode().contains(id)) {
				return readValues.get(i).getProvinceName();
			}
			List<MallCityList> cityLists = readValues.get(i).getMallCityList();
			for (int j = 0; j < cityLists.size(); j++) {

				List<MallAreaList> mallAreaList = cityLists.get(j).getMallAreaList();
				if(cityLists.get(j).getCityCode().contains(id)) {
					return cityLists.get(j).getCityName();
				}

				for(MallAreaList e:mallAreaList) {
					if(e.getAreaCode().contains(id)) {
						return e.getAreaName();
					}
				}

			}

		}
		return null;


	}



	/**
	 * 根据中文获取该中文是省还是市或者是区
	 *
	 */



	public static String getdq(String name) {
		for (int i = 0; i < readValues.size(); i++) {

			if(readValues.get(i).getProvinceName().equals(name)) {
				return "省级";
			}

			List<MallCityList> cityLists = readValues.get(i).getMallCityList();
			for (int j = 0; j < cityLists.size(); j++) {

				List<MallAreaList> mallAreaList = cityLists.get(j).getMallAreaList();
				if(cityLists.get(j).getCityName().equals(name)) {
					return "市级";
				}

				for(MallAreaList e:mallAreaList) {
					if(e.getAreaName().equals(name)) {
						return "区级";
					}
				}

			}

		}
		return null;


	}
	/**
	 *
	 */
	public static List<Map> toCityList(){
		ArrayList<Map> regionList = new ArrayList<>();
		List<Map> parse = JSON.parseArray(PCAUtils.pca, Map.class);
		//省级
		Map province = parse.get(0);
		HashMap<Object, Object> provinceMap = new HashMap<>();
		String provinceName = (String) province.get("provinceName");
		String provinceCode = (String) province.get("provinceCode");
		provinceMap.put("name",provinceName);
		provinceMap.put("code",provinceCode);
		provinceMap.put("level","1");
		regionList.add(provinceMap);
		//市级
		List cityList = (List) province.get("mallCityList");
		System.out.println("市级数量"+cityList.size());
		for (Object obj:cityList) {
			Map city = (Map) obj;
			String cityCode = (String) city.get("cityCode");
			String cityName = (String) city.get("cityName");
			HashMap<String, String> cityMap = new HashMap<>();
			cityMap.put("code",cityCode);
			cityMap.put("name",cityName);
			cityMap.put("level","2");
			regionList.add(cityMap);
		}
		System.out.println(regionList);
		return regionList;
	}
	/**
	 *
	 * @return  list包含所有地区   地区为map表示   包含地区名称 key(name) 地区编码key(code) 地区级别key(level{1为省级,2为市级,3为县级})
	 */
	public static List<Map> toList(){
		ArrayList<Map> regionList = new ArrayList<>();
		List<Map> parse = JSON.parseArray(PCAUtils.pca, Map.class);
		//省级
		Map province = parse.get(0);
		HashMap<Object, Object> provinceMap = new HashMap<>();
		String provinceName = (String) province.get("provinceName");
		String provinceCode = (String) province.get("provinceCode");
		provinceMap.put("name",provinceName);
		provinceMap.put("code",provinceCode);
		provinceMap.put("level","1");
		regionList.add(provinceMap);
		//市级
		List cityList = (List) province.get("mallCityList");
		System.out.println("市级数量"+cityList.size());
		for (Object obj:cityList) {
			Map city = (Map) obj;
			String cityCode = (String) city.get("cityCode");
			String cityName = (String) city.get("cityName");
			HashMap<String, String> cityMap = new HashMap<>();
			cityMap.put("code",cityCode);
			cityMap.put("name",cityName);
			cityMap.put("level","2");
			regionList.add(cityMap);
			//县级
			List mallAreaList = (List) city.get("mallAreaList");
			System.out.println("\t"+cityName+"\t县级数量:"+mallAreaList.size());
			for(Object obj2:mallAreaList){

				Map area = (Map) obj2;
				String areaCode = (String) area.get("areaCode");
				String areaName = (String) area.get("areaName");
				HashMap<String, String> areaMap = new HashMap<>();
				areaMap.put("code",areaCode);
				areaMap.put("name",areaName);
				areaMap.put("level","3");
				regionList.add(areaMap);
				System.out.println("\t\t县名:"+areaName);
			}
		}
		System.out.println(regionList);
		return regionList;
	}


	/**
	 * 根据任意对应id返回其父级
	 *
	 */

	public static String getPid(String id) {
		for (int i = 0; i < readValues.size(); i++) {

			List<MallCityList> cityLists = readValues.get(i).getMallCityList();
			for (int j = 0; j < cityLists.size(); j++) {

				List<MallAreaList> mallAreaList = cityLists.get(j).getMallAreaList();
				if(cityLists.get(j).getCityCode().contains(id)) {
					return cityLists.get(j).getCityName();
				}

				for(MallAreaList e:mallAreaList) {
					if(e.getAreaCode().contains(id)) {

						return cityLists.get(j).getCityCode();
					}
				}

			}

		}
		return null;


	}
	
	public static void main(String[] args) {
		System.out.println(getPid("411728"));
	}
}
