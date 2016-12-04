package com.nyameh.kmitlnavi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NyaMehDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "์NyaMeh";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "Location";
    public static final String COL_NAME = "name";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_LATITUDE = "latitude";
    public static final String COL_LONGITUDE = "longtitude";
    public static final String COL_CODE = "code";

    public static final String TABLE_NAME2 = "New";
    public static final String COL_TITLE = "title";
    public static final String COL_CONTENT = "content";
    public static final String COL_POSITION ="position";
    public static final String COL_DATE = "date";


    public NyaMehDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format(
                "CREATE TABLE %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT );",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคาร ศ.ประสมรังสิโรจน์", " คณะสถาปัตยกรรมศาสตร์ อาคาร ศ.ประสมรังสิโรจน์ เป็นอาคารของคณะสถาปัตยกรรมศาสตร์ สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง ตั้งชื่อตึกตามศ.ประสม รังสิโรจน์ คณะบดีคนแรก", "13.729541", "100.7749593", "L001"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "หอประชุมใหญ่สถาบัน", "คณะวิศวกรรมศาสตร์ เป็นหอประชุมของคณะวิศวกรรมศาสตร์ สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง สร้างขึ้นในปีพ.ศ.2518 เป็นสถานที่ประชุมและจัดกิจกรรมต่างๆของสถาบัน", "13.7276435", "100.7771469", "L002"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารคณะเทคโนโลยีสารสนเทศ", "โถงใหญ่ชั้น1สำหรับทำกิจกรรมและพักผ่อนของอาคารคณะเทคโนโลยีสารสนเทศ สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "13.73109123", "100.781261980", "L003"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารกรมหลวงนราธิวาสราชนครินทร์", "สำนักงานอธิการบดีสถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "13.730760", "100.777672", "L004"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "หอพระราชประวัติร.4", "หอเก็บพระราชประวัติของรัชกาลที่ 4 และลานพระจอมที่จัดกิจกรรมของสถาบัน", "13.730807", "100.778666", "L005"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารเรียนรวมสมเด็จพระเทพฯ", "อาคารเรียนรวมของนักศึกษาในสถาบันสำหรับทุกคณะ", "13.730005", "100.776459", "L006"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "สมาคมศิษย์เก่าสถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "อาคารติดต่อ สอบถามและร่วมกิจกรรมเกี่ยวกับนักศึกษาที่จบการศึกษาแล้ว", "13.731102", "100.774747", "L007"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "โรงอาหารพระเทพ", "โรงอาหารติดกับอาคารเรียนรวมสมเด็จพระเทพฯ", "13.729996", "100.775867", "L008"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารปฏิบัติการวิศวกรรม 2", "อาคารสำหรับการทดลองและปฏิบัติการของคณะวิศวกรรมศาสตร์", "13.729220", "100.775614", "L009"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "หอพักนักศึกษา", "หอพักแบบพัดลมและแอร์ของนักศึกษาในสถาบัน", "13.729775", "100.774569", "L010"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารวิจัยนาโนเทคโนโลยีสิรินธร", "อาคารเรียนและปฏิบัติการของวิทยาลัยนาโนเทคโนโลยี สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "13.728883", "100.777377", "L011"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "สำนักงานคณบดีคณะวิศวกรรมศาสตร์", "สำนักงานคณบดีคณะวิศวกรรมศาสตร์สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "13.727145", "100.776206", "L012"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "สอาคารเรียนรวมคณะวิศวกรรมศาสตร์12ชั้น", "อาคารเรียนรวมของคณะวิศวกรรมศาสตร์ มีทั้งสิ้น12ชั้นและสูงที่สุดในสถาบัน", "13.727366", "100.772513", "L013"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารเฉลิมพระเกียรติ 84 พรรษาภูมิพลมหาราชา", "อาคารเฉลิมพระเกียรติ เนื่องในโอกาศ 84 พรรษาภูมิพลมหาราชา", "13.726590", "100.775309", "L014"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "สำนักงานคณบดีคณะสถาปัตยกรรมศาสตร์", "สำนักงานคณบดีคณะสถาปัตยกรรมศาสตร์สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "13.725290", "100.776615", "L015"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "หอประชุมศาสตราจารย์ประสม รังสิโรจน", "อาคารเรียนของคณะสถาปัตยกรรมศาสตร์ตั้งตามชื่อคณะบดีคนแรกของคณะ", "13.725692", "100.775011", "L016"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารบูรณาการ", "อาคารเรียนและทำกิจกรรมของคณะสถาปัตยกรรมศาสตร์", "13.725728", "100.773784", "L017"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารเรียนรวมสถาปัตยกรรมศาสตร์", "อาคารเรียนรวมทุกสาขาของคณะสถาปัตยกรรมศาสตร์", "13.725174", "100.775053", "L018"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารเจ้าคุณทหารคณะเทคโนโลยีการเกษตรและคณะอุตสาหกรรมการเกษตร", "อาคารเรียนรวมของคณะเทคโนโลยีการเกษตรและคณะอุตสาหกรรมการเกษตร", "13.726245", "100.780741", "L019"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "หอประชุมเจ้าพระยาสุรวงศ์ไวยวัตน์ (วร บุนนาค)", "หอประชุมใหญ่สำหรับงานสำคัญและการมอบปริญญาบัตร", "13.726737", "100.779105", "L020"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "สำนักหอสมุดกลาง", "หอสมุดและแหล่งการเรียนรู้สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "13.727884", "100.778532", "L021"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "องค์การนักศึกษาสจล.", "ตึกทำการขององค์การนักศึกษาสถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "13.729296", "100.778584", "L022"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "คณะวิทยาศาสตร์", "ตึกเรียนคณะวิทยาศาสตร์", "13.729284", "100.779714", "L023"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "คณะครุศาสตร์อุตสาหกรรม", "ตึกเรียนคณะครุศาสตร์อุตสาหกรรม", "13.729672", "100.780983", "L024"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "อาคารบุนนาคคณะเทคโนโลยีการเกษตร", "อาคารเรียนของคณะเทคโนโลยีการเกษตร", "13.729801", "100.781889", "L025"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "สำนักบริการคอมพิวเตอร์และวิทยาลัยการบริหารและจัดการ", "ตึกสำหรับให้บริการเกี่ยวกับคอมพิวเตอร์และเนตเวิร์คในสถาบัน รวมทั้งเป็นตึกเรียนของวิทยาลัยการบริหารและจัดการ", "13.731131", "100.780285", "L026"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "สนามกีฬา สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "สนามกีฬาใหญ่สำหรับนักศึกษาสถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "13.730059", "100.772189", "L027"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s', '%s');",
                TABLE_NAME, COL_NAME, COL_DESCRIPTION, COL_LATITUDE, COL_LONGITUDE, COL_CODE,
                "ลานกิจกรรมข้างสนามกีฬา", "ลานว่างพักผ่อนและออกกำลังกายของสถาบัน", "13.728920", "100.772179", "L028"
        ));

        db.execSQL(String.format(
                "CREATE TABLE %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT );",
                TABLE_NAME2, COL_TITLE, COL_CONTENT, COL_POSITION, COL_DATE
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s');",
                TABLE_NAME2, COL_TITLE, COL_CONTENT, COL_POSITION, COL_DATE,
                "ขอเชิญพี่น้องชาว สจล. ร่วมรวมพลังแห่งความภักดี 22 พ.ย.นี้", "ขอเชิญนักศึกษา คณาจารย์ บุคลากรของสถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง ร่วมงาน “รวมพลังแห่งความภักดี” เพื่อประกาศความจงรักภักดี และร่วมรำลึกถึงพระบาทสมเด็จพระปรมินทรมหาภูมิพลอดุลยเดชพร้อมกันทั่วประเทศ ในวันอังคารที่ 22 พฤศจิกายน 2559 \n" +
                        "ณ ลานเอนกประสงค์ ชั้น 1 สำนักงานอธิการบดี อาคารกรมหลวงนราธิวาสราชนครินทร์ เวลา 7.30 น. \n" +
                        "แต่งกายสุภาพ ไว้ทุกข์ (สำหรับข้าราชการแต่งชุดปกติขาวไว้ทุกข์)", "L004", "59/11/22"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s');",
                TABLE_NAME2, COL_TITLE, COL_CONTENT, COL_POSITION, COL_DATE,
                "เรียนTOEICฟรี รุ่นสุดท้าย", "ด้วยสถาบันโดยส่วนกิจการนักศึกษา จัดโครงการเตรียมความพร้อมสู่ประชาคมอาเซี่ยน ปีงบประมาณ 2559\n" +
                        "เปิดหลักสูตร TOEIC , Job Interview , Presentation , Academic Writing โดยสอนภาษาอังกฤษให้นักศึกษาของสถาบัน นักศึกษาปริญญาตรี ปริญญาโท ปริญญาเอก และนักศึกษาที่จบการศึกษาไปแล้วไม่เกิน 1 ปี โดยไม่คิดค่าใช้จ่าย\n" +
                        "รอบสุดท้ายก่อนจบโครงการเรียนฟรีภาษาอังกฤษ 2559 KMITL\n" +
                        "สอบวันที่ 30 สิงหาคม 2559 เวลา 16.30 – 18.30 น.\n" +
                        "ลงทะเบียนออนไลน์ หรือที่ New Education World สาขา ลาดกระบัง\n" +
                        "ชั้น 2 อาคารเรียนรวมสมเด็จพระเทพ\n" +
                        "ตั้งแต่วันที่ 11 - 26 ส.ค. 2559 นี้เท่านั้น\n" +
                        "พิเศษ!! เฉพาะออนไลน์เท่านั้น\n" +
                        "เมื่อลงทะเบียนแล้ว สามารถติดต่อรับของที่ระลึกจากทางสถาบันได้ทันที\n" +
                        "สอบถามรายละเอียดเพิ่มเติมโทร 02 326 4633", "L006", "59/08/11"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s');",
                TABLE_NAME2, COL_TITLE, COL_CONTENT, COL_POSITION, COL_DATE,
                "อบรมการปลูกพืชโดยไม่ใช้ดินรุ่นพิเศษ เรื่อง การปลูกพืชโดยไม่ใช้ดินแนวใหม่ที่มีการใช้น้ำและปุ๋ยอย่างมีประสิทธิภาพ", "คณะเทคโนโลยีการเกษตร สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบังร่วมกับสำนักงานกองทุนสนับสนุนการวิจัย (สกว.) การฝึกอบรมการปลูกพืชโดยไม่ใช้ดินรุ่นพิเศษ เรื่อง การปลูกพืชโดยไม่ใช้ดินแนวใหม่ที่มีการใช้น้ำและปุ๋ยอย่างมีประสิทธิภาพ\n" +
                        "\n" +
                        "\n" +
                        "วันที่ 15-16 ตุลาคม 2559\n" +
                        "ณ คณะเทคโนโลยีการเกษตร อาคารเจ้าคุณทหาร", "L019", "59/10/15"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s');",
                TABLE_NAME2, COL_TITLE, COL_CONTENT, COL_POSITION, COL_DATE,
                "พิธีพระราชทานปริญญาบัตรของสถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบังประจำปีการศึกษา 2558 (ปี 2559)", "นัดซ้อมย่อยบัณฑิตกรณีพิเศษในวันเสาร์ที่ 12 พฤศจิกายน 2559 เวลา 13.00 น. ณ ห้อง 107 อาคาร ศ.ประสมรังสิโรจน์ คณะสถาปัตยกรรมศาสตร์ โปรดหลีกเลี่ยงเส้นทางการจราจรบริเวณใกล้เคียงสถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง\n" +
                        "เนื่องจากพิธีพระราชทานปริญญาบัตรในวันที่ 12-13 และ 16 พฤศจิกายน 2559", "L001", "59/10/02"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s');",
                TABLE_NAME2, COL_TITLE, COL_CONTENT, COL_POSITION, COL_DATE,
                "เรียนTOEICฟรี รุ่นสุดท้าย", "ด้วยสถาบันโดยส่วนกิจการนักศึกษา จัดโครงการเตรียมความพร้อมสู่ประชาคมอาเซี่ยน ปีงบประมาณ 2559\n" +
                        "เปิดหลักสูตร TOEIC , Job Interview , Presentation , Academic Writing โดยสอนภาษาอังกฤษให้นักศึกษาของสถาบัน นักศึกษาปริญญาตรี ปริญญาโท ปริญญาเอก และนักศึกษาที่จบการศึกษาไปแล้วไม่เกิน 1 ปี โดยไม่คิดค่าใช้จ่าย\n" +
                        "รอบสุดท้ายก่อนจบโครงการเรียนฟรีภาษาอังกฤษ 2559 KMITL\n" +
                        "สอบวันที่ 30 สิงหาคม 2559 เวลา 16.30 – 18.30 น.\n" +
                        "ลงทะเบียนออนไลน์ หรือที่ New Education World สาขา ลาดกระบัง\n" +
                        "ชั้น 2 อาคารเรียนรวมสมเด็จพระเทพ\n" +
                        "ตั้งแต่วันที่ 11 - 26 ส.ค. 2559 นี้เท่านั้น\n" +
                        "พิเศษ!! เฉพาะออนไลน์เท่านั้น\n" +
                        "เมื่อลงทะเบียนแล้ว สามารถติดต่อรับของที่ระลึกจากทางสถาบันได้ทันที\n" +
                        "สอบถามรายละเอียดเพิ่มเติมโทร 02 326 4633", "L006", "59/08/11"
        ));

        db.execSQL(String.format(
                "INSERT INTO %s (%s, %s, %s, %s) VALUES('%s', '%s', '%s', '%s');",
                TABLE_NAME2, COL_TITLE, COL_CONTENT, COL_POSITION, COL_DATE,
                "ขอเชิญร่วมบริจาคโลหิต", "ขอเชิญอาจารย์ บุคลากร และนักศึกษาในสถาบัน ฯ ทุกท่าน ร่วมบริจาคโลหิตกับศูนย์บริการโลหิตแห่งชาติ สภากาชาดไทย \n" +
                        "ในวันที่ 31 ตุลาคม 2559 และ 1 พฤศจิกายน 2559 เวลา 09.00 - 15.00 น. ณ งานสุขภาพอนามัย อาคารสมเด็จพระเทพฯ สถาบันเทคโนโลยี พระจอมเกล้าเจ้าคุณทหารลาดกระบัง", "L006", "59/10/31"
        ));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
