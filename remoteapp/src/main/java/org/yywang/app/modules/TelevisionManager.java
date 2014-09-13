package org.yywang.app.modules;

import org.yywang.app.framework.event.EventLoader;
import org.yywang.app.framework.exception.AppBizExpection;
import org.yywang.app.framework.log.Log;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.TVStatus;
import org.yywang.app.model.Television;
import org.yywang.app.transmission.TransmissionCur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 电视管理
 *
 * @author yywang
 */
public class TelevisionManager {


    private List<Television> televisions = new ArrayList<Television>();

    /**
     * 扫描电视
     *
     * @return 电视列表
     */
    public List<Television> scanTvs() {
        CallingLogger.instance.append("TelevisionManager.scanTvs");
        PrintUtils.println("扫描周围的电视中,请稍后", 6);
        televisions.add(new Television("haier", "01", TVStatus.online));
        televisions.add(new Television("tcl", "01", TVStatus.online));
        televisions.addAll(mockScanedTvs());
        Log.instance.info("扫描周围电视");
        return televisions;
    }

    /**
     * 选择电视
     *
     * @param bandModel 品牌类型
     */
    public void choiceTv(String bandModel) {
        CallingLogger.instance.append("TelevisionManager.choiceTv");
        PrintUtils.println("您选择的电视为：" + bandModel);
        Log.instance.info("您选择的电视为：" + bandModel);
        for (Television television : televisions) {
            String tvBandModel = television.getBrand() + television.getModel();
            if (tvBandModel.equals(bandModel)) {
                PrintUtils.println("正在连接", 3);
                TransmissionCur.Instance.init(bandModel);
                EventLoader.load(tvBandModel);
                PrintUtils.println("连接成功！");
                return;
            }
        }
        throw new AppBizExpection(String.format("您选择的电视%s 不存在！", bandModel));
    }

    /**
     * 模拟已经存在的电视
     *
     * @return 已存在电视
     */
    private List<Television> mockScanedTvs() {
        List<Television> televisions = new ArrayList<Television>();
        Television television = new Television();
        television.setBrand("haier");
        television.setModel("H03");
        television.setTvStatus(TVStatus.offline);
        television.setLastUseTime(new Date());
        televisions.add(television);
        return televisions;
    }
}
