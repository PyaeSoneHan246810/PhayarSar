package com.pyaesonehan.phayarsar.presentation.core.preview

import com.pyaesonehan.phayarsar.domain.model.Detail
import com.pyaesonehan.phayarsar.domain.model.Group
import com.pyaesonehan.phayarsar.domain.model.Item

object PreviewData {
    val groups: List<Group> = listOf(
        Group(
            groupId = 1,
            title = "ဘုရားရှိခိုး",
            data = listOf(
                Item(
                    id = 1,
                    groupId = 1,
                    title = "သြကာသကန်တော့ချိုးဖြင့် ကန်တော့ပုံ"
                ),
                Item(
                    id = 2,
                    groupId = 1,
                    title = "သြကာသကန်တော့ချိုးဖြင့် ကန်တော့ပုံ ဘုရားရှိခိုး (နမောတဿ)"
                )
            )
        ),
        Group(
            groupId = 2,
            title = "သီလခံယူတည်ဆောက်ပုံ",
            data = listOf(
                Item(
                    id = 1,
                    groupId = 2,
                    title = "ငါးပါးသီလ ခံယူတည်ဆောက်ပုံ"
                ),
                Item(
                    id = 2,
                    groupId = 1,
                    title = "ရှစ်ပါးသီလ ခံယူတည်ဆောက်ပုံ"
                )
            )
        )
    )
    val detail: Detail = Detail(
        id = 1,
        groupId = 1,
        title = "သြကာသကန်တော့ချိုးဖြင့် ကန်တော့ပုံ",
        content = "သြကာသ၊ သြကာသ၊ သြကာသ \n\nကာယကံ၊ ဝစီကံ၊ မနောကံ သဗ္ဗဒေါသ ခပ်သိမ်းသော အပြစ်တို့ကို ပျောက်ပါစေခြင်း အကျိုးငှာ ပထမ၊ ဒုတိယ၊ တတိယ၊ တစ်ကြိမ်၊ နှစ်ကြိမ်၊ သုံးကြိမ်မြောက်အောင် ဘုရားရတနာ၊ တရားရတနာ၊ သံဃာရတနာ၊ ရတနာမြတ်သုံးပါးတို့ကို အရိုအသေ အလေးအမြတ် လက်အုပ်မိုး၍ ရှိခိုးပူဇော် ဖူးမြော်မာန်လျှော့ ကန်တော့ပါ၏။ \n\nအရှင်ဘုရား။ ကန်တော့ရသော အကျိုးအားကြောင့် အပါယ်လေးပါး၊ ကပ်သုံးပါး၊ ရပ်ပြစ်ရှစ်ပါး၊ ရန်သူမျိုးငါးပါး၊ ဝိပတ္တိတရားလေးပါး၊ ဗျသနတရား ငါးပါး တို့မှ အခါခပ်သိမ်း ကင်းလွတ်ငြိမ်းသည်ဖြစ်၍ မဂ်တရား၊ ဖိုလ်တရား နိဗ္ဗာန်ချမ်းသာ တရားတော်မြတ်ကို ရပါလို၏အရှင်ဘုရား။"
    )
}