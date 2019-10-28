package com.bupt.heartarea.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bupt.heartarea.R;
import com.bupt.heartarea.constants.Constants;

public class SelfEvalutionActivity extends Activity {
    private int[] R_id1;
    private int[] R_id2;
    private int[] R_id3;
    private int[] R_id4;
    private int[] R_id5;
    private Button btn_self_evalution_commit;
    private String getSelfEvalution;
    private String[] getSelfEvalutions;
    private ImageView iv_self_evalution_back;
    private double level;
    private String[] rb_selected;
    private String rb_selected1;
    private String rb_selected10;
    private String rb_selected11;
    private String rb_selected12;
    private String rb_selected13;
    private String rb_selected14;
    private String rb_selected15;
    private String rb_selected16;
    private String rb_selected17;
    private String rb_selected18;
    private String rb_selected19;
    private String rb_selected2;
    private String rb_selected20;
    private String rb_selected21;
    private String rb_selected22;
    private String rb_selected23;
    private String rb_selected24;
    private String rb_selected25;
    private String rb_selected26;
    private String rb_selected27;
    private String rb_selected28;
    private String rb_selected29;
    private String rb_selected3;
    private String rb_selected30;
    private String rb_selected31;
    private String rb_selected32;
    private String rb_selected33;
    private String rb_selected34;
    private String rb_selected35;
    private String rb_selected36;
    private String rb_selected37;
    private String rb_selected38;
    private String rb_selected39;
    private String rb_selected4;
    private String rb_selected40;
    private String rb_selected41;
    private String rb_selected42;
    private String rb_selected43;
    private String rb_selected44;
    private String rb_selected45;
    private String rb_selected46;
    private String rb_selected47;
    private String rb_selected48;
    private String rb_selected49;
    private String rb_selected5;
    private String rb_selected50;
    private String rb_selected51;
    private String rb_selected52;
    private String rb_selected53;
    private String rb_selected54;
    private String rb_selected55;
    private String rb_selected56;
    private String rb_selected57;
    private String rb_selected58;
    private String rb_selected59;
    private String rb_selected6;
    private String rb_selected60;
    private String rb_selected61;
    private String rb_selected62;
    private String rb_selected63;
    private String rb_selected64;
    private String rb_selected65;
    private String rb_selected66;
    private String rb_selected67;
    private String rb_selected68;
    private String rb_selected69;
    private String rb_selected7;
    private String rb_selected70;
    private String rb_selected71;
    private String rb_selected72;
    private String rb_selected73;
    private String rb_selected74;
    private String rb_selected75;
    private String rb_selected76;
    private String rb_selected77;
    private String rb_selected78;
    private String rb_selected79;
    private String rb_selected8;
    private String rb_selected80;
    private String rb_selected81;
    private String rb_selected82;
    private String rb_selected83;
    private String rb_selected84;
    private String rb_selected85;
    private String rb_selected86;
    private String rb_selected87;
    private String rb_selected88;
    private String rb_selected89;
    private String rb_selected9;
    private String rb_selected90;
    private RadioButton[] rb_self1;
    private RadioButton rb_self101;
    private RadioButton rb_self102;
    private RadioButton rb_self103;
    private RadioButton rb_self104;
    private RadioButton rb_self105;
    private RadioButton rb_self11;
    private RadioButton rb_self111;
    private RadioButton rb_self112;
    private RadioButton rb_self113;
    private RadioButton rb_self114;
    private RadioButton rb_self115;
    private RadioButton rb_self12;
    private RadioButton rb_self121;
    private RadioButton rb_self122;
    private RadioButton rb_self123;
    private RadioButton rb_self124;
    private RadioButton rb_self125;
    private RadioButton rb_self13;
    private RadioButton rb_self131;
    private RadioButton rb_self132;
    private RadioButton rb_self133;
    private RadioButton rb_self134;
    private RadioButton rb_self135;
    private RadioButton rb_self14;
    private RadioButton rb_self141;
    private RadioButton rb_self142;
    private RadioButton rb_self143;
    private RadioButton rb_self144;
    private RadioButton rb_self145;
    private RadioButton rb_self15;
    private RadioButton rb_self151;
    private RadioButton rb_self152;
    private RadioButton rb_self153;
    private RadioButton rb_self154;
    private RadioButton rb_self155;
    private RadioButton rb_self161;
    private RadioButton rb_self162;
    private RadioButton rb_self163;
    private RadioButton rb_self164;
    private RadioButton rb_self165;
    private RadioButton rb_self171;
    private RadioButton rb_self172;
    private RadioButton rb_self173;
    private RadioButton rb_self174;
    private RadioButton rb_self175;
    private RadioButton rb_self181;
    private RadioButton rb_self182;
    private RadioButton rb_self183;
    private RadioButton rb_self184;
    private RadioButton rb_self185;
    private RadioButton rb_self191;
    private RadioButton rb_self192;
    private RadioButton rb_self193;
    private RadioButton rb_self194;
    private RadioButton rb_self195;
    private RadioButton[] rb_self2;
    private RadioButton rb_self201;
    private RadioButton rb_self202;
    private RadioButton rb_self203;
    private RadioButton rb_self204;
    private RadioButton rb_self205;
    private RadioButton rb_self21;
    private RadioButton rb_self211;
    private RadioButton rb_self212;
    private RadioButton rb_self213;
    private RadioButton rb_self214;
    private RadioButton rb_self215;
    private RadioButton rb_self22;
    private RadioButton rb_self221;
    private RadioButton rb_self222;
    private RadioButton rb_self223;
    private RadioButton rb_self224;
    private RadioButton rb_self225;
    private RadioButton rb_self23;
    private RadioButton rb_self231;
    private RadioButton rb_self232;
    private RadioButton rb_self233;
    private RadioButton rb_self234;
    private RadioButton rb_self235;
    private RadioButton rb_self24;
    private RadioButton rb_self241;
    private RadioButton rb_self242;
    private RadioButton rb_self243;
    private RadioButton rb_self244;
    private RadioButton rb_self245;
    private RadioButton rb_self25;
    private RadioButton rb_self251;
    private RadioButton rb_self252;
    private RadioButton rb_self253;
    private RadioButton rb_self254;
    private RadioButton rb_self255;
    private RadioButton rb_self261;
    private RadioButton rb_self262;
    private RadioButton rb_self263;
    private RadioButton rb_self264;
    private RadioButton rb_self265;
    private RadioButton rb_self271;
    private RadioButton rb_self272;
    private RadioButton rb_self273;
    private RadioButton rb_self274;
    private RadioButton rb_self275;
    private RadioButton rb_self281;
    private RadioButton rb_self282;
    private RadioButton rb_self283;
    private RadioButton rb_self284;
    private RadioButton rb_self285;
    private RadioButton rb_self291;
    private RadioButton rb_self292;
    private RadioButton rb_self293;
    private RadioButton rb_self294;
    private RadioButton rb_self295;
    private RadioButton[] rb_self3;
    private RadioButton rb_self301;
    private RadioButton rb_self302;
    private RadioButton rb_self303;
    private RadioButton rb_self304;
    private RadioButton rb_self305;
    private RadioButton rb_self31;
    private RadioButton rb_self311;
    private RadioButton rb_self312;
    private RadioButton rb_self313;
    private RadioButton rb_self314;
    private RadioButton rb_self315;
    private RadioButton rb_self32;
    private RadioButton rb_self321;
    private RadioButton rb_self322;
    private RadioButton rb_self323;
    private RadioButton rb_self324;
    private RadioButton rb_self325;
    private RadioButton rb_self33;
    private RadioButton rb_self331;
    private RadioButton rb_self332;
    private RadioButton rb_self333;
    private RadioButton rb_self334;
    private RadioButton rb_self335;
    private RadioButton rb_self34;
    private RadioButton rb_self341;
    private RadioButton rb_self342;
    private RadioButton rb_self343;
    private RadioButton rb_self344;
    private RadioButton rb_self345;
    private RadioButton rb_self35;
    private RadioButton rb_self351;
    private RadioButton rb_self352;
    private RadioButton rb_self353;
    private RadioButton rb_self354;
    private RadioButton rb_self355;
    private RadioButton rb_self361;
    private RadioButton rb_self362;
    private RadioButton rb_self363;
    private RadioButton rb_self364;
    private RadioButton rb_self365;
    private RadioButton rb_self371;
    private RadioButton rb_self372;
    private RadioButton rb_self373;
    private RadioButton rb_self374;
    private RadioButton rb_self375;
    private RadioButton rb_self381;
    private RadioButton rb_self382;
    private RadioButton rb_self383;
    private RadioButton rb_self384;
    private RadioButton rb_self385;
    private RadioButton rb_self391;
    private RadioButton rb_self392;
    private RadioButton rb_self393;
    private RadioButton rb_self394;
    private RadioButton rb_self395;
    private RadioButton[] rb_self4;
    private RadioButton rb_self401;
    private RadioButton rb_self402;
    private RadioButton rb_self403;
    private RadioButton rb_self404;
    private RadioButton rb_self405;
    private RadioButton rb_self41;
    private RadioButton rb_self411;
    private RadioButton rb_self412;
    private RadioButton rb_self413;
    private RadioButton rb_self414;
    private RadioButton rb_self415;
    private RadioButton rb_self42;
    private RadioButton rb_self421;
    private RadioButton rb_self422;
    private RadioButton rb_self423;
    private RadioButton rb_self424;
    private RadioButton rb_self425;
    private RadioButton rb_self43;
    private RadioButton rb_self431;
    private RadioButton rb_self432;
    private RadioButton rb_self433;
    private RadioButton rb_self434;
    private RadioButton rb_self435;
    private RadioButton rb_self44;
    private RadioButton rb_self441;
    private RadioButton rb_self442;
    private RadioButton rb_self443;
    private RadioButton rb_self444;
    private RadioButton rb_self445;
    private RadioButton rb_self45;
    private RadioButton rb_self451;
    private RadioButton rb_self452;
    private RadioButton rb_self453;
    private RadioButton rb_self454;
    private RadioButton rb_self455;
    private RadioButton rb_self461;
    private RadioButton rb_self462;
    private RadioButton rb_self463;
    private RadioButton rb_self464;
    private RadioButton rb_self465;
    private RadioButton rb_self471;
    private RadioButton rb_self472;
    private RadioButton rb_self473;
    private RadioButton rb_self474;
    private RadioButton rb_self475;
    private RadioButton rb_self481;
    private RadioButton rb_self482;
    private RadioButton rb_self483;
    private RadioButton rb_self484;
    private RadioButton rb_self485;
    private RadioButton rb_self491;
    private RadioButton rb_self492;
    private RadioButton rb_self493;
    private RadioButton rb_self494;
    private RadioButton rb_self495;
    private RadioButton[] rb_self5;
    private RadioButton rb_self501;
    private RadioButton rb_self502;
    private RadioButton rb_self503;
    private RadioButton rb_self504;
    private RadioButton rb_self505;
    private RadioButton rb_self51;
    private RadioButton rb_self511;
    private RadioButton rb_self512;
    private RadioButton rb_self513;
    private RadioButton rb_self514;
    private RadioButton rb_self515;
    private RadioButton rb_self52;
    private RadioButton rb_self521;
    private RadioButton rb_self522;
    private RadioButton rb_self523;
    private RadioButton rb_self524;
    private RadioButton rb_self525;
    private RadioButton rb_self53;
    private RadioButton rb_self531;
    private RadioButton rb_self532;
    private RadioButton rb_self533;
    private RadioButton rb_self534;
    private RadioButton rb_self535;
    private RadioButton rb_self54;
    private RadioButton rb_self541;
    private RadioButton rb_self542;
    private RadioButton rb_self543;
    private RadioButton rb_self544;
    private RadioButton rb_self545;
    private RadioButton rb_self55;
    private RadioButton rb_self551;
    private RadioButton rb_self552;
    private RadioButton rb_self553;
    private RadioButton rb_self554;
    private RadioButton rb_self555;
    private RadioButton rb_self561;
    private RadioButton rb_self562;
    private RadioButton rb_self563;
    private RadioButton rb_self564;
    private RadioButton rb_self565;
    private RadioButton rb_self571;
    private RadioButton rb_self572;
    private RadioButton rb_self573;
    private RadioButton rb_self574;
    private RadioButton rb_self575;
    private RadioButton rb_self581;
    private RadioButton rb_self582;
    private RadioButton rb_self583;
    private RadioButton rb_self584;
    private RadioButton rb_self585;
    private RadioButton rb_self591;
    private RadioButton rb_self592;
    private RadioButton rb_self593;
    private RadioButton rb_self594;
    private RadioButton rb_self595;
    private RadioButton rb_self601;
    private RadioButton rb_self602;
    private RadioButton rb_self603;
    private RadioButton rb_self604;
    private RadioButton rb_self605;
    private RadioButton rb_self61;
    private RadioButton rb_self611;
    private RadioButton rb_self612;
    private RadioButton rb_self613;
    private RadioButton rb_self614;
    private RadioButton rb_self615;
    private RadioButton rb_self62;
    private RadioButton rb_self621;
    private RadioButton rb_self622;
    private RadioButton rb_self623;
    private RadioButton rb_self624;
    private RadioButton rb_self625;
    private RadioButton rb_self63;
    private RadioButton rb_self631;
    private RadioButton rb_self632;
    private RadioButton rb_self633;
    private RadioButton rb_self634;
    private RadioButton rb_self635;
    private RadioButton rb_self64;
    private RadioButton rb_self641;
    private RadioButton rb_self642;
    private RadioButton rb_self643;
    private RadioButton rb_self644;
    private RadioButton rb_self645;
    private RadioButton rb_self65;
    private RadioButton rb_self651;
    private RadioButton rb_self652;
    private RadioButton rb_self653;
    private RadioButton rb_self654;
    private RadioButton rb_self655;
    private RadioButton rb_self661;
    private RadioButton rb_self662;
    private RadioButton rb_self663;
    private RadioButton rb_self664;
    private RadioButton rb_self665;
    private RadioButton rb_self671;
    private RadioButton rb_self672;
    private RadioButton rb_self673;
    private RadioButton rb_self674;
    private RadioButton rb_self675;
    private RadioButton rb_self681;
    private RadioButton rb_self682;
    private RadioButton rb_self683;
    private RadioButton rb_self684;
    private RadioButton rb_self685;
    private RadioButton rb_self691;
    private RadioButton rb_self692;
    private RadioButton rb_self693;
    private RadioButton rb_self694;
    private RadioButton rb_self695;
    private RadioButton rb_self701;
    private RadioButton rb_self702;
    private RadioButton rb_self703;
    private RadioButton rb_self704;
    private RadioButton rb_self705;
    private RadioButton rb_self71;
    private RadioButton rb_self711;
    private RadioButton rb_self712;
    private RadioButton rb_self713;
    private RadioButton rb_self714;
    private RadioButton rb_self715;
    private RadioButton rb_self72;
    private RadioButton rb_self721;
    private RadioButton rb_self722;
    private RadioButton rb_self723;
    private RadioButton rb_self724;
    private RadioButton rb_self725;
    private RadioButton rb_self73;
    private RadioButton rb_self731;
    private RadioButton rb_self732;
    private RadioButton rb_self733;
    private RadioButton rb_self734;
    private RadioButton rb_self735;
    private RadioButton rb_self74;
    private RadioButton rb_self741;
    private RadioButton rb_self742;
    private RadioButton rb_self743;
    private RadioButton rb_self744;
    private RadioButton rb_self745;
    private RadioButton rb_self75;
    private RadioButton rb_self751;
    private RadioButton rb_self752;
    private RadioButton rb_self753;
    private RadioButton rb_self754;
    private RadioButton rb_self755;
    private RadioButton rb_self761;
    private RadioButton rb_self762;
    private RadioButton rb_self763;
    private RadioButton rb_self764;
    private RadioButton rb_self765;
    private RadioButton rb_self771;
    private RadioButton rb_self772;
    private RadioButton rb_self773;
    private RadioButton rb_self774;
    private RadioButton rb_self775;
    private RadioButton rb_self781;
    private RadioButton rb_self782;
    private RadioButton rb_self783;
    private RadioButton rb_self784;
    private RadioButton rb_self785;
    private RadioButton rb_self791;
    private RadioButton rb_self792;
    private RadioButton rb_self793;
    private RadioButton rb_self794;
    private RadioButton rb_self795;
    private RadioButton rb_self801;
    private RadioButton rb_self802;
    private RadioButton rb_self803;
    private RadioButton rb_self804;
    private RadioButton rb_self805;
    private RadioButton rb_self81;
    private RadioButton rb_self811;
    private RadioButton rb_self812;
    private RadioButton rb_self813;
    private RadioButton rb_self814;
    private RadioButton rb_self815;
    private RadioButton rb_self82;
    private RadioButton rb_self821;
    private RadioButton rb_self822;
    private RadioButton rb_self823;
    private RadioButton rb_self824;
    private RadioButton rb_self825;
    private RadioButton rb_self83;
    private RadioButton rb_self831;
    private RadioButton rb_self832;
    private RadioButton rb_self833;
    private RadioButton rb_self834;
    private RadioButton rb_self835;
    private RadioButton rb_self84;
    private RadioButton rb_self841;
    private RadioButton rb_self842;
    private RadioButton rb_self843;
    private RadioButton rb_self844;
    private RadioButton rb_self845;
    private RadioButton rb_self85;
    private RadioButton rb_self851;
    private RadioButton rb_self852;
    private RadioButton rb_self853;
    private RadioButton rb_self854;
    private RadioButton rb_self855;
    private RadioButton rb_self861;
    private RadioButton rb_self862;
    private RadioButton rb_self863;
    private RadioButton rb_self864;
    private RadioButton rb_self865;
    private RadioButton rb_self871;
    private RadioButton rb_self872;
    private RadioButton rb_self873;
    private RadioButton rb_self874;
    private RadioButton rb_self875;
    private RadioButton rb_self881;
    private RadioButton rb_self882;
    private RadioButton rb_self883;
    private RadioButton rb_self884;
    private RadioButton rb_self885;
    private RadioButton rb_self891;
    private RadioButton rb_self892;
    private RadioButton rb_self893;
    private RadioButton rb_self894;
    private RadioButton rb_self895;
    private RadioButton rb_self901;
    private RadioButton rb_self902;
    private RadioButton rb_self903;
    private RadioButton rb_self904;
    private RadioButton rb_self905;
    private RadioButton rb_self91;
    private RadioButton rb_self92;
    private RadioButton rb_self93;
    private RadioButton rb_self94;
    private RadioButton rb_self95;
    private int[] score;
    private int self_evalution_score = 0;
    private int[] yy;
    private boolean flag;
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_evalution_information);
        initView();
        initEvent();
    }

    private void initView() {
        iv_self_evalution_back = (ImageView)findViewById(R.id.iv_self_evalution_back);
        btn_self_evalution_commit = (Button)findViewById(R.id.btn_self_evalution_commit);
        rb_self1 = new RadioButton[] {
                rb_self11, rb_self21, rb_self31, rb_self41, rb_self51, rb_self61, rb_self71, rb_self81, rb_self91, rb_self101,
                rb_self111, rb_self121, rb_self131, rb_self141, rb_self151, rb_self161, rb_self171, rb_self181, rb_self191, rb_self201,
                rb_self211, rb_self221, rb_self231, rb_self241, rb_self251, rb_self261, rb_self271, rb_self281, rb_self291, rb_self301,
                rb_self311, rb_self321, rb_self331, rb_self341, rb_self351, rb_self361, rb_self371, rb_self381, rb_self391, rb_self401,
                rb_self411, rb_self421, rb_self431, rb_self441, rb_self451, rb_self461, rb_self471, rb_self481, rb_self491, rb_self501,
                rb_self511, rb_self521, rb_self531, rb_self541, rb_self551, rb_self561, rb_self571, rb_self581, rb_self591, rb_self601,
                rb_self611, rb_self621, rb_self631, rb_self641, rb_self651, rb_self661, rb_self671, rb_self681, rb_self691, rb_self701,
                rb_self711, rb_self721, rb_self731, rb_self741, rb_self751, rb_self761, rb_self771, rb_self781, rb_self791, rb_self801,
                rb_self811, rb_self821, rb_self831, rb_self841, rb_self851, rb_self861, rb_self871, rb_self881, rb_self891, rb_self901 };
        rb_self2 = new RadioButton[] {
                rb_self12, rb_self22, rb_self32, rb_self42, rb_self52, rb_self62, rb_self72, rb_self82, rb_self92, rb_self102,
                rb_self112, rb_self122, rb_self132, rb_self142, rb_self152, rb_self162, rb_self172, rb_self182, rb_self192, rb_self202,
                rb_self212, rb_self222, rb_self232, rb_self242, rb_self252, rb_self262, rb_self272, rb_self282, rb_self292, rb_self302,
                rb_self312, rb_self322, rb_self332, rb_self342, rb_self352, rb_self362, rb_self372, rb_self382, rb_self392, rb_self402,
                rb_self412, rb_self422, rb_self432, rb_self442, rb_self452, rb_self462, rb_self472, rb_self482, rb_self492, rb_self502,
                rb_self512, rb_self522, rb_self532, rb_self542, rb_self552, rb_self562, rb_self572, rb_self582, rb_self592, rb_self602,
                rb_self612, rb_self622, rb_self632, rb_self642, rb_self652, rb_self662, rb_self672, rb_self682, rb_self692, rb_self702,
                rb_self712, rb_self722, rb_self732, rb_self742, rb_self752, rb_self762, rb_self772, rb_self782, rb_self792, rb_self802,
                rb_self812, rb_self822, rb_self832, rb_self842, rb_self852, rb_self862, rb_self872, rb_self882, rb_self892, rb_self902 };
        rb_self3 = new RadioButton[] {
                rb_self13, rb_self23, rb_self33, rb_self43, rb_self53, rb_self63, rb_self73, rb_self83, rb_self93, rb_self103,
                rb_self113, rb_self123, rb_self133, rb_self143, rb_self153, rb_self163, rb_self173, rb_self183, rb_self193, rb_self203,
                rb_self213, rb_self223, rb_self233, rb_self243, rb_self253, rb_self263, rb_self273, rb_self283, rb_self293, rb_self303,
                rb_self313, rb_self323, rb_self333, rb_self343, rb_self353, rb_self363, rb_self373, rb_self383, rb_self393, rb_self403,
                rb_self413, rb_self423, rb_self433, rb_self443, rb_self453, rb_self463, rb_self473, rb_self483, rb_self493, rb_self503,
                rb_self513, rb_self523, rb_self533, rb_self543, rb_self553, rb_self563, rb_self573, rb_self583, rb_self593, rb_self603,
                rb_self613, rb_self623, rb_self633, rb_self643, rb_self653, rb_self663, rb_self673, rb_self683, rb_self693, rb_self703,
                rb_self713, rb_self723, rb_self733, rb_self743, rb_self753, rb_self763, rb_self773, rb_self783, rb_self793, rb_self803,
                rb_self813, rb_self823, rb_self833, rb_self843, rb_self853, rb_self863, rb_self873, rb_self883, rb_self893, rb_self903 };
        rb_self4 = new RadioButton[] {
                rb_self14, rb_self24, rb_self34, rb_self44, rb_self54, rb_self64, rb_self74, rb_self84, rb_self94, rb_self104,
                rb_self114, rb_self124, rb_self134, rb_self144, rb_self154, rb_self164, rb_self174, rb_self184, rb_self194, rb_self204,
                rb_self214, rb_self224, rb_self234, rb_self244, rb_self254, rb_self264, rb_self274, rb_self284, rb_self294, rb_self304,
                rb_self314, rb_self324, rb_self334, rb_self344, rb_self354, rb_self364, rb_self374, rb_self384, rb_self394, rb_self404,
                rb_self414, rb_self424, rb_self434, rb_self444, rb_self454, rb_self464, rb_self474, rb_self484, rb_self494, rb_self504,
                rb_self514, rb_self524, rb_self534, rb_self544, rb_self554, rb_self564, rb_self574, rb_self584, rb_self594, rb_self604,
                rb_self614, rb_self624, rb_self634, rb_self644, rb_self654, rb_self664, rb_self674, rb_self684, rb_self694, rb_self704,
                rb_self714, rb_self724, rb_self734, rb_self744, rb_self754, rb_self764, rb_self774, rb_self784, rb_self794, rb_self804,
                rb_self814, rb_self824, rb_self834, rb_self844, rb_self854, rb_self864, rb_self874, rb_self884, rb_self894, rb_self904 };
        rb_self5 = new RadioButton[] {
                rb_self15, rb_self25, rb_self35, rb_self45, rb_self55, rb_self65, rb_self75, rb_self85, rb_self95, rb_self105,
                rb_self115, rb_self125, rb_self135, rb_self145, rb_self155, rb_self165, rb_self175, rb_self185, rb_self195, rb_self205,
                rb_self215, rb_self225, rb_self235, rb_self245, rb_self255, rb_self265, rb_self275, rb_self285, rb_self295, rb_self305,
                rb_self315, rb_self325, rb_self335, rb_self345, rb_self355, rb_self365, rb_self375, rb_self385, rb_self395, rb_self405,
                rb_self415, rb_self425, rb_self435, rb_self445, rb_self455, rb_self465, rb_self475, rb_self485, rb_self495, rb_self505,
                rb_self515, rb_self525, rb_self535, rb_self545, rb_self555, rb_self565, rb_self575, rb_self585, rb_self595, rb_self605,
                rb_self615, rb_self625, rb_self635, rb_self645, rb_self655, rb_self665, rb_self675, rb_self685, rb_self695, rb_self705,
                rb_self715, rb_self725, rb_self735, rb_self745, rb_self755, rb_self765, rb_self775, rb_self785, rb_self795, rb_self805,
                rb_self815, rb_self825, rb_self835, rb_self845, rb_self855, rb_self865, rb_self875, rb_self885, rb_self895, rb_self905 };
        rb_selected = new String[] {
                rb_selected1, rb_selected2, rb_selected3, rb_selected4, rb_selected5, rb_selected6, rb_selected7, rb_selected8, rb_selected9, rb_selected10,
                rb_selected11, rb_selected12, rb_selected13, rb_selected14, rb_selected15, rb_selected16, rb_selected17, rb_selected18, rb_selected19, rb_selected20,
                rb_selected21, rb_selected22, rb_selected23, rb_selected24, rb_selected25, rb_selected26, rb_selected27, rb_selected28, rb_selected29, rb_selected30,
                rb_selected31, rb_selected32, rb_selected33, rb_selected34, rb_selected35, rb_selected36, rb_selected37, rb_selected38, rb_selected39, rb_selected40,
                rb_selected41, rb_selected42, rb_selected43, rb_selected44, rb_selected45, rb_selected46, rb_selected47, rb_selected48, rb_selected49, rb_selected50,
                rb_selected51, rb_selected52, rb_selected53, rb_selected54, rb_selected55, rb_selected56, rb_selected57, rb_selected58, rb_selected59, rb_selected60,
                rb_selected61, rb_selected62, rb_selected63, rb_selected64, rb_selected65, rb_selected66, rb_selected67, rb_selected68, rb_selected69, rb_selected70,
                rb_selected71, rb_selected72, rb_selected73, rb_selected74, rb_selected75, rb_selected76, rb_selected77, rb_selected78, rb_selected79, rb_selected80,
                rb_selected81, rb_selected82, rb_selected83, rb_selected84, rb_selected85, rb_selected86, rb_selected87, rb_selected88, rb_selected89, rb_selected90 };
        R_id1 = new int[] {
                R.id.self11, R.id.self21, R.id.self31, R.id.self41, R.id.self51, R.id.self61, R.id.self71, R.id.self81, R.id.self91, R.id.self101,
                R.id.self111, R.id.self121, R.id.self131, R.id.self141, R.id.self151, R.id.self161, R.id.self171, R.id.self181, R.id.self191, R.id.self201,
                R.id.self211, R.id.self221, R.id.self231, R.id.self241, R.id.self251, R.id.self261, R.id.self271, R.id.self281, R.id.self291, R.id.self301,
                R.id.self311, R.id.self321, R.id.self331, R.id.self341, R.id.self351, R.id.self361, R.id.self371, R.id.self381, R.id.self391, R.id.self401,
                R.id.self411, R.id.self421, R.id.self431, R.id.self441, R.id.self451, R.id.self461, R.id.self471, R.id.self481, R.id.self491, R.id.self501,
                R.id.self511, R.id.self521, R.id.self531, R.id.self541, R.id.self551, R.id.self561, R.id.self571, R.id.self581, R.id.self591, R.id.self601,
                R.id.self611, R.id.self621, R.id.self631, R.id.self641, R.id.self651, R.id.self661, R.id.self671, R.id.self681, R.id.self691, R.id.self701,
                R.id.self711, R.id.self721, R.id.self731, R.id.self741, R.id.self751, R.id.self761, R.id.self771, R.id.self781, R.id.self791, R.id.self801,
                R.id.self811, R.id.self821, R.id.self831, R.id.self841, R.id.self851, R.id.self861, R.id.self871, R.id.self881, R.id.self891, R.id.self901};
        R_id2 = new int[] {
                R.id.self12, R.id.self22, R.id.self32, R.id.self42, R.id.self52, R.id.self62, R.id.self72, R.id.self82, R.id.self92, R.id.self102,
                R.id.self112, R.id.self122, R.id.self132, R.id.self142, R.id.self152, R.id.self162, R.id.self172, R.id.self182, R.id.self192, R.id.self202,
                R.id.self212, R.id.self222, R.id.self232, R.id.self242, R.id.self252, R.id.self262, R.id.self272, R.id.self282, R.id.self292, R.id.self302,
                R.id.self312, R.id.self322, R.id.self332, R.id.self342, R.id.self352, R.id.self362, R.id.self372, R.id.self382, R.id.self392, R.id.self402,
                R.id.self412, R.id.self422, R.id.self432, R.id.self442, R.id.self452, R.id.self462, R.id.self472, R.id.self482, R.id.self492, R.id.self502,
                R.id.self512, R.id.self522, R.id.self532, R.id.self542, R.id.self552, R.id.self562, R.id.self572, R.id.self582, R.id.self592, R.id.self602,
                R.id.self612, R.id.self622, R.id.self632, R.id.self642, R.id.self652, R.id.self662, R.id.self672, R.id.self682, R.id.self692, R.id.self702,
                R.id.self712, R.id.self722, R.id.self732, R.id.self742, R.id.self752, R.id.self762, R.id.self772, R.id.self782, R.id.self792, R.id.self802,
                R.id.self812, R.id.self822, R.id.self832, R.id.self842, R.id.self852, R.id.self862, R.id.self872, R.id.self882, R.id.self892, R.id.self902};
        R_id3 = new int[] {
                R.id.self13, R.id.self23, R.id.self33, R.id.self43, R.id.self53, R.id.self63, R.id.self73, R.id.self83, R.id.self93, R.id.self103,
                R.id.self113, R.id.self123, R.id.self133, R.id.self143, R.id.self153, R.id.self163, R.id.self173, R.id.self183, R.id.self193, R.id.self203,
                R.id.self213, R.id.self223, R.id.self233, R.id.self243, R.id.self253, R.id.self263, R.id.self273, R.id.self283, R.id.self293, R.id.self303,
                R.id.self313, R.id.self323, R.id.self333, R.id.self343, R.id.self353, R.id.self363, R.id.self373, R.id.self383, R.id.self393, R.id.self403,
                R.id.self413, R.id.self423, R.id.self433, R.id.self443, R.id.self453, R.id.self463, R.id.self473, R.id.self483, R.id.self493, R.id.self503,
                R.id.self513, R.id.self523, R.id.self533, R.id.self543, R.id.self553, R.id.self563, R.id.self573, R.id.self583, R.id.self593, R.id.self603,
                R.id.self613, R.id.self623, R.id.self633, R.id.self643, R.id.self653, R.id.self663, R.id.self673, R.id.self683, R.id.self693, R.id.self703,
                R.id.self713, R.id.self723, R.id.self733, R.id.self743, R.id.self753, R.id.self763, R.id.self773, R.id.self783, R.id.self793, R.id.self803,
                R.id.self813, R.id.self823, R.id.self833, R.id.self843, R.id.self853, R.id.self863, R.id.self873, R.id.self883, R.id.self893, R.id.self903 };
        R_id4 = new int[] {
                R.id.self14, R.id.self24, R.id.self34, R.id.self44, R.id.self54, R.id.self64, R.id.self74, R.id.self84, R.id.self94, R.id.self104,
                R.id.self114, R.id.self124, R.id.self134, R.id.self144, R.id.self154, R.id.self164, R.id.self174, R.id.self184, R.id.self194, R.id.self204,
                R.id.self214, R.id.self224, R.id.self234, R.id.self244, R.id.self254, R.id.self264, R.id.self274, R.id.self284, R.id.self294, R.id.self304,
                R.id.self314, R.id.self324, R.id.self334, R.id.self344, R.id.self354, R.id.self364, R.id.self374, R.id.self384, R.id.self394, R.id.self404,
                R.id.self414, R.id.self424, R.id.self434, R.id.self444, R.id.self454, R.id.self464, R.id.self474, R.id.self484, R.id.self494, R.id.self504,
                R.id.self514, R.id.self524, R.id.self534, R.id.self544, R.id.self554, R.id.self564, R.id.self574, R.id.self584, R.id.self594, R.id.self604,
                R.id.self614, R.id.self624, R.id.self634, R.id.self644, R.id.self654, R.id.self664, R.id.self674, R.id.self684, R.id.self694, R.id.self704,
                R.id.self714, R.id.self724, R.id.self734, R.id.self744, R.id.self754, R.id.self764, R.id.self774, R.id.self784, R.id.self794, R.id.self804,
                R.id.self814, R.id.self824, R.id.self834, R.id.self844, R.id.self854, R.id.self864, R.id.self874, R.id.self884, R.id.self894, R.id.self904};
        R_id5 = new int[] {
                R.id.self15, R.id.self25, R.id.self35, R.id.self45, R.id.self55, R.id.self65, R.id.self75, R.id.self85, R.id.self95, R.id.self105,
                R.id.self115, R.id.self125, R.id.self135, R.id.self145, R.id.self155, R.id.self165, R.id.self175, R.id.self185, R.id.self195, R.id.self205,
                R.id.self215, R.id.self225, R.id.self235, R.id.self245, R.id.self255, R.id.self265, R.id.self275, R.id.self285, R.id.self295, R.id.self305,
                R.id.self315, R.id.self325, R.id.self335, R.id.self345, R.id.self355, R.id.self365, R.id.self375, R.id.self385, R.id.self395, R.id.self405,
                R.id.self415, R.id.self425, R.id.self435, R.id.self445, R.id.self455, R.id.self465, R.id.self475, R.id.self485, R.id.self495, R.id.self505,
                R.id.self515, R.id.self525, R.id.self535, R.id.self545, R.id.self555, R.id.self565, R.id.self575, R.id.self585, R.id.self595, R.id.self605,
                R.id.self615, R.id.self625, R.id.self635, R.id.self645, R.id.self655, R.id.self665, R.id.self675, R.id.self685, R.id.self695, R.id.self705,
                R.id.self715, R.id.self725, R.id.self735, R.id.self745, R.id.self755, R.id.self765, R.id.self775, R.id.self785, R.id.self795, R.id.self805,
                R.id.self815, R.id.self825, R.id.self835, R.id.self845, R.id.self855, R.id.self865, R.id.self875, R.id.self885, R.id.self895, R.id.self905 };
        byte b;
        for (b = 0; b < 90; b++) {
            rb_self1[b] = (RadioButton)findViewById(R_id1[b]);
            rb_self2[b] = (RadioButton)findViewById(R_id2[b]);
            rb_self3[b] = (RadioButton)findViewById(R_id3[b]);
            rb_self4[b] = (RadioButton)findViewById(R_id4[b]);
            rb_self5[b] = (RadioButton)findViewById(R_id5[b]);
        }
        score = new int[90];
        yy = new int[90];
        for (b = 0; b < 90; b++) {
            score[b] = -1;
            yy[b] = -1;
        }
        getSelfEvalution = Constants.getSelf_evalution_info();
        if (!getSelfEvalution.equals("")) {
            getSelfEvalutions = getSelfEvalution.split(",");
            for (b = 0; b < 90; b++) {
                if (getSelfEvalutions[b].equals("0")) {
                    rb_self1[b].setChecked(true);
                } else if (getSelfEvalutions[b].equals("1")) {
                    rb_self2[b].setChecked(true);
                } else if (getSelfEvalutions[b].equals("2")) {
                    rb_self3[b].setChecked(true);
                } else if (getSelfEvalutions[b].equals("3")) {
                    rb_self4[b].setChecked(true);
                } else {
                    rb_self5[b].setChecked(true);
                }
            }
        }
    }

    private void initEvent() {
        iv_self_evalution_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) { openDialog(); }
        });
        getSelfEvalution = Constants.getSelf_evalution_info();
        if (getSelfEvalution.equals("")) {
            setParamsTrue();
        } else {
            setParamsFalse();
            setParamsTrue();
        }
        btn_self_evalution_commit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                self_evalution_score = 0;
                flag = true;
                String str2 = "";
                String str1 = "";
                int j = 0;
                byte b1 = 0;
                for (int i = 0; i < 90; i++) {
                    if (score[i] == 1) {
                        j++;
                    } else {
                        b1++;
                    }
                }
                for (j = 0; j < 90; j++) {
                    str2 = str2 + "rb" + (j + 1) + " = " + rb_selected[j] + "\n";
                    str1 = str1 + rb_selected[j] + ",";
                }
                str1 = str1.substring(0, str1.length() - 1);
                j = 0;
                String[] test = str1.split(",");

                for (int i =0;i<test.length;i++){
                    self_evalution_score = self_evalution_score + score[i];
                    if (test[i].equals("null")){
                        flag = false;
                        Log.e(TAG, "onClick: "+i );
                        break;
                    }
                }
                if (flag){
                    Constants.setSelf_evalution_info(str1);
                    Constants.setSelf_evalution_score(self_evalution_score);
                    Log.e(TAG, "onClick: "+Constants.getSelf_evalution_info() );
                    Log.e(TAG, "onClick: "+Constants.getSelf_evalution_score() );
                    Intent intent = new Intent(SelfEvalutionActivity.this,MainQSActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(SelfEvalutionActivity.this, "您还有未选择项", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setParamsFalse() {
        for (byte b = 0; b < 90; b++) {
            if (rb_self1[b].isChecked()) {
                rb_selected[b] = "0";
                score[b] = 1;
                yy[b] = 0;
            } else if (rb_self2[b].isChecked()) {
                rb_selected[b] = "1";
                score[b] = 2;
                yy[b] = 1;
            } else if (rb_self3[b].isChecked()) {
                rb_selected[b] = "2";
                score[b] = 3;
                yy[b] = 1;
            } else if (rb_self4[b].isChecked()) {
                rb_selected[b] = "3";
                score[b] = 4;
                yy[b] = 1;
            } else if (rb_self5[b].isChecked()) {
                rb_selected[b] = "4";
                score[b] = 5;
                yy[b] = 1;
            } else {
                rb_selected[b] = null;
                score[b] = -1;
                yy[b] = -1;
            }
        }
    }

    private void setParamsTrue() {
        for (int b = 0; b < 90; b++) {
            final int finalI = b;
            rb_self1[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_selected[finalI] = "0";
                    score[finalI] = 1;
                    yy[finalI] = 0;
                }
            });
        }
        for (int b = 0; b < 90; b++) {
            final int finalI = b;
            rb_self2[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_selected[finalI] = "1";
                    score[finalI] = 2;
                    yy[finalI] = 1;
                }
            });
        }
        for (int b = 0; b < 90; b++) {
            final int finalI = b;
            rb_self3[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_selected[finalI] = "2";
                    score[finalI] = 3;
                    yy[finalI] = 1;
                }
            });
        }
        for (int b = 0; b < 90; b++) {
            final int finalI = b;
            rb_self4[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_selected[finalI] = "3";
                    score[finalI] = 4;
                    yy[finalI] = 1;
                }
            });
        }
        for (int b = 0; b < 90; b++) {
            final int finalI = b;
            rb_self5[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_selected[finalI] = "4";
                    score[finalI] = 5;
                    yy[finalI] = 1;
                }
            });
        }
    }
    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Intent intent = new Intent(SelfEvalutionActivity.this, MainQSActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        });
        builder.setMessage("您确定要返回主界面吗");
        builder.setTitle("提示！");
        builder.show();
    }
}
