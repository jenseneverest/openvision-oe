DESCRIPTION = "Control your receiver with a browser"
MAINTAINER = "Open Vision Developers"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;firstline=10;lastline=12;md5=9c14f792d0aeb54e15490a28c89087f7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python-cheetah-native"

RDEPENDS_${PN} = "\
	aio-grab \
	python-cheetah \
	python-compression\
	python-ipaddress\
	python-json \
	python-misc \
	python-numbers \
	python-pyopenssl \
	python-shell \
	python-unixadmin \
	"

inherit gitpkgv distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/OpenWebif.git;protocol=git"

SRC_URI_append_sh4 += " file://revert_grab_for_sh4.patch "

S="${WORKDIR}/git"

do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
}

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif"
do_install_append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}
}

FILES_${PN} = "${PLUGINPATH}"

python do_cleanup () {
    # contains: MACHINE, box image, remote image, remote map
    boxtypes = [
        ('vusolo', 'vusolo.png', 'vu.png', 'vu.html'),
        ('vuduo', 'vuduo.png', 'vu.png', 'vu.html'),
        ('vuuno', 'vuuno.png', 'vu.png', 'vu.html'),
        ('vusolo2', 'vusolo2.png', 'vu.png', 'vu.html'),
        ('vusolose', 'vusolose.png', 'vu.png', 'vu.html'),
        ('vuzero', 'vuzero.png', 'vu.png', 'vu.html'),
        ('vusolo4k', 'vusolo4k.png', 'vu.png', 'vu.html'),
        ('vuuno4k', 'vuuno4k.png', 'vu.png', 'vu.html'),
        ('vuultimo4k', 'vuultimo4k.png', 'vu.png', 'vu.html'),
        ('vuultimo', 'vuultimo.png', 'vu2.png', 'vu2.html'),
        ('vuduo2', 'vuduo2.png', 'vu3.png', 'vu3.html'),
        ('vuuno4kse', 'vuuno4kse.png', 'vu4.png', 'vu4.html'),
        ('vuzero4k', 'vuzero4k.png', 'vu4.png', 'vu4.html'),
        ('vuduo4k', 'vuduo4k.png', 'vu4.png', 'vu4.html'),
        ('evoe3hd', 'evoe3hd.png', 'e3hd.png', 'e3hd.html'),
        ('geniuse3hd', 'geniuse3hd.png', 'e3hd.png', 'e3hd.html'),
        ('axase3', 'axase3.png', 'e3hd.png', 'e3hd.html'),
        ('axase3c', 'axase3c.png', 'e3hd.png', 'e3hd.html'),
        ('et9x00', 'et9x00.png', 'et9x00.png', 'et9x00.html'),
        ('et5x00', 'et5x00.png', 'et6x00.png', 'et6x00.html'),
        ('et6x00', 'et6x00.png', 'et6x00.png', 'et6x00.html'),
        ('et4x00', 'et4x00.png', 'et4x00.png', 'et4x00.html'),
        ('et8000', 'et8000.png', 'et8000.png', 'et8000.html'),
        ('et8500', 'et8500.png', 'et8000.png', 'et8000.html'),
        ('et10000', 'et10000.png', 'et8000.png', 'et8000.html'),
        ('et7x00', 'et7x00.png', 'et7x00.png', 'et7x00.html'),
        ('et1x000', 'et1x000.png', 'et7x00mini.png', 'et7x00mini.html'),
        ('et7000mini', 'et7000mini.png', 'et7x00mini.png', 'et7x00mini.html'),
        ('gbquad', 'gbquad.png', 'gb0.png', 'gb0.html'),
        ('gb800se', 'gb800se.png', 'gb0.png', 'gb0.html'),
        ('gb800ue', 'gb800ue.png', 'gb0.png', 'gb0.html'),
        ('gb800solo', 'gb800solo.png', 'gb0.png', 'gb0.html'),
        ('gb800seplus', 'gb800seplus.png', 'gb0.png', 'gb0.html'),
        ('gb800ueplus', 'gb800ueplus.png', 'gb0.png', 'gb0.html'),
        ('gbipbox', 'gbipbox.png', 'gb0.png', 'gb0.html'),
        ('gbultrase', 'gbultrase.png', 'gb0.png', 'gb0.html'),
        ('gbultraue', 'gbultraue.png', 'gb0.png', 'gb0.html'),
        ('gbx1', 'gbx1.png', 'gb0.png', 'gb0.html'),
        ('gbx3', 'gbx3.png', 'gb0.png', 'gb0.html'),
        ('gbquadplus', 'gbquadplus.png', 'gb1.png', 'gb1.html'),
        ('gbx2', 'gbx2.png', 'gb2.png', 'gb2.html'),
        ('gbx3h', 'gbx3h.png', 'gb2.png', 'gb2.html'),
        ('gbultraueh', 'gbultraueh.png', 'gb2.png', 'gb2.html'),
        ('gbquad4k', 'gbquad4k.png', 'gb3.png', 'gb3.html'),
        ('gbue4k', 'gbue4k.png', 'gb3.png', 'gb3.html'),
        ('gbtrio4k', 'gbtrio4k.png', 'gb3.png', 'gb3.html'),
        ('gbip4k', 'gbip4k.png', 'gb3.png', 'gb3.html'),
        ('gbx34k', 'gbx34k.png', 'gb3.png', 'gb3.html'),
        ('formuler1', 'formuler1.png', 'formuler1.png', 'formuler1.html'),
        ('formuler3', 'formuler3.png', 'formuler1.png', 'formuler1.html'),
        ('formuler4', 'formuler4.png', 'formuler1.png', 'formuler1.html'),
        ('formuler4turbo', 'formuler4turbo.png', 'formuler1.png', 'formuler1.html'),
        ('azboxme', 'azboxme.png', 'azboxme.png', 'azboxme.html'),
        ('azboxminime', 'azboxminime.png', 'azboxme.png', 'azboxme.html'),
        ('azboxhd', 'azboxhd.png', 'azboxhd.png', 'azboxhd.html'),
        ('optimussos', 'optimussos.png', 'optimuss1.png', 'optimuss1.html'),
        ('optimussos1', 'optimussos1.png', 'optimuss1.png', 'optimuss1.html'),
        ('optimussos1plus', 'optimussos1plus.png', 'optimuss1.png', 'optimuss1.html'),
        ('optimussos2', 'optimussos2.png', 'optimuss1.png', 'optimuss1.html'),
        ('optimussos2plus', 'optimussos2plus.png', 'optimuss1.png', 'optimuss1.html'),
        ('optimussos3plus', 'optimussos3plus.png', 'optimuss2.png', 'optimuss2.html'),
        ('mbtwinplus', 'mbtwinplus.png', 'miraclebox.png', 'miraclebox.html'),
        ('mbmicro', 'mbmicro.png', 'miraclebox.png', 'miraclebox.html'),
        ('mbmicrov2', 'mbmicrov2.png', 'miraclebox.png', 'miraclebox.html'),
        ('alphatriplehd', 'alphatriplehd.png', 'sab1.png', 'sab1.html'),
        ('xp1000', 'xp1000.png', 'xp1000.png', 'xp1000.html'),
        ('adb_box', 'adb_box.png', 'nbox.png', 'nbox.html'),
        ('adb_2850', 'adb_2850.png', 'nbox.png', 'nbox.html'),
        ('arivalink200', 'arivalink200.png', 'nbox.png', 'nbox.html'),
        ('sagemcom88', 'sagemcom88.png', 'nbox.png', 'nbox.html'),
        ('spark', 'spark.png', 'fulan.png', 'fulan.html'),
        ('spark7162', 'spark7162.png', 'fulan.png', 'fulan.html'),
        ('hd1100', 'hd1100.png', 'hd1100.png', 'hd1100.html'),
        ('hd1200', 'hd1200.png', 'hd1100.png', 'hd1100.html'),
        ('hd1265', 'hd1265.png', 'hd1100.png', 'hd1100.html'),
        ('hd51', 'hd51.png', 'hd1100.png', 'hd1100.html'),
        ('hd11', 'hd11.png', 'hd1100.png', 'hd1100.html'),
        ('hd500c', 'hd500c.png', 'hd1100.png', 'hd1100.html'),
        ('hd1500', 'hd1500.png', 'hd1100.png', 'hd1100.html'),
        ('vs1000', 'vs1000.png', 'hd1100.png', 'hd1100.html'),
        ('vs1500', 'vs1500.png', 'hd1100.png', 'hd1100.html'),
        ('hd2400', 'hd2400.png', 'hd2400.png', 'hd2400.html'),
        ('hd530c', 'hd530c.png', 'hd530c.png', 'hd530c.html'),
        ('hd60', 'hd60.png', 'hd60.png', 'hd60.html'),
        ('hd61', 'hd61.png', 'ax4.png', 'ax4.html'),
        ('multibox', 'multibox.png', 'maxytec1.png', 'maxytec1.html'),
        ('spycat', 'spycat.png', 'xcore1.png', 'xcore1.html'),
        ('spycatmini', 'spycatmini.png', 'xcore1.png', 'xcore1.html'),
        ('spycatminiplus', 'spycatminiplus.png', 'xcore1.png', 'xcore1.html'),
        ('spycat4kmini', 'spycat4kmini.png', 'xcore1.png', 'xcore1.html'),
        ('spycat4k', 'spycat4k.png', 'xcore1.png', 'xcore1.html'),
        ('spycat4kcombo', 'spycat4kcombo.png', 'xcore1.png', 'xcore1.html'),
        ('osmini', 'osmini.png', 'xcore3.png', 'xcore3.html'),
        ('osminiplus', 'osminiplus.png', 'xcore3.png', 'xcore3.html'),
        ('osmega', 'osmega.png', 'xcore3.png', 'xcore3.html'),
        ('ixussone', 'ixussone.png', 'ixuss.png', 'ixuss.html'),
        ('ixusszero', 'ixusszero.png', 'ixuss.png', 'ixuss.html'),
        ('dm8000', 'dm8000.png', 'dmm0.png', 'dmm0.html'),
        ('dm800', 'dm800.png', 'dmm1.png', 'dmm1.html'),
        ('dm800se', 'dm800se.png', 'dmm1.png', 'dmm1.html'),
        ('dm500hd', 'dm500hd.png', 'dmm1.png', 'dmm1.html'),
        ('dm7080', 'dm7080.png', 'dmm2.png', 'dmm2.html'),
        ('dm7020hd', 'dm7020hd.png', 'dmm2.png', 'dmm2.html'),
        ('dm7020hdv2', 'dm7020hd.png', 'dmm2.png', 'dmm2.html'),
        ('dm800sev2', 'dm800se.png', 'dmm2.png', 'dmm2.html'),
        ('dm500hdv2', 'dm500hd.png', 'dmm2.png', 'dmm2.html'),
        ('dm520', 'dm520.png', 'dmm2.png', 'dmm2.html'),
        ('dm820', 'dm820.png', 'dmm2.png', 'dmm2.html'),
        ('dm900', 'dm900.png', 'dmm2.png', 'dmm2.html'),
        ('dm920', 'dm920.png', 'dmm2.png', 'dmm2.html'),
        ('dreamone', 'dreamone.png', 'dmm2.png', 'dmm2.html'),
        ('wetekplay', 'wetekplay.png', 'wetek.png', 'wetek.html'),
        ('wetekplay2', 'wetekplay2.png', 'wetek2.png', 'wetek2.html'),
        ('wetekhub', 'wetekhub.png', 'wetek3.png', 'wetek3.html'),
        ('osnino', 'osnino.png', 'edision1.png', 'edision1.html'),
        ('osninoplus', 'osninoplus.png', 'edision1.png', 'edision1.html'),
        ('osninopro', 'osninopro.png', 'edision2.png', 'edision2.html'),
        ('osmini4k', 'osmio4k.png', 'edision3.png', 'edision3.html'),
        ('osmio4k', 'osmio4k.png', 'edision3.png', 'edision3.html'),
        ('osmio4kplus', 'osmio4kplus.png', 'edision3.png', 'edision3.html'),
        ('fusionhd', 'fusionhd.png', 'fusionhd.png', 'fusionhd.html'),
        ('fusionhdse', 'fusionhdse.png', 'fusionhd.png', 'fusionhd.html'),
        ('purehd', 'purehd.png', 'fusionhd.png', 'fusionhd.html'),
        ('purehdse', 'purehdse.png', 'fusionhd.png', 'fusionhd.html'),
        ('revo4k', 'revo4k.png', 'revo.png', 'revo.html'),
        ('galaxy4k', 'galaxy4k.png', 'revo.png', 'revo.html'),
        ('lunix34k', 'lunix34k.png', 'qviart1.png', 'qviart1.html'),
        ('lunix', 'lunix.png', 'qviart1.png', 'qviart1.html'),
        ('lunix4k', 'lunix4k.png', 'qviart3.png', 'qviart3.html'),
        ('lunixco', 'lunixco.png', 'qviart4.png', 'qviart4.html'),
        ('sh1', 'sh1.png', 'zgemma1.png', 'zgemma1.html'),
        ('lc', 'lc.png', 'zgemma2.png', 'zgemma2.html'),
        ('h3', 'h3.png', 'zgemma3.png', 'zgemma3.html'),
        ('h4', 'h4.png', 'zgemma3.png', 'zgemma3.html'),
        ('h5', 'h5.png', 'zgemma3.png', 'zgemma3.html'),
        ('h6', 'h5.png', 'zgemma3.png', 'zgemma3.html'),
        ('h7', 'h7.png', 'zgemma3.png', 'zgemma3.html'),
        ('h9', 'h9.png', 'zgemma3.png', 'zgemma3.html'),
        ('h9combo', 'h9combo.png', 'zgemma3.png', 'zgemma3.html'),
        ('h10', 'h10.png', 'zgemma7.png', 'zgemma7.html'),
        ('i55plus', 'i55plus.png', 'zgemma3.png', 'zgemma3.html'),
        ('i55', 'i55.png', 'zgemma5.png', 'zgemma5.html'),
        ('vipercombohdd', 'vipercombohdd.png', 'amiko1.png', 'amiko1.html'),
        ('vipercombo', 'vipercombo.png', 'amiko2.png', 'amiko2.html'),
        ('vipert2c', 'vipert2c.png', 'amiko2.png', 'amiko2.html'),
        ('viperslim', 'viperslim.png', 'amiko2.png', 'amiko2.html'),
        ('alien5', 'alien5.png', 'amiko3.png', 'amiko3.html'),
        ('viper4k', 'viper4k.png', 'amiko4.png', 'amiko4.html'),
        ('k1pro', 'k1pro.png', 'k1pro.png', 'k1pro.html'),
        ('k2pro', 'k2pro.png', 'k1pro.png', 'k1pro.html'),
        ('k2prov2', 'k2pro.png', 'k1pro.png', 'k1pro.html'),
        ('k1plus', 'k1plus.png', 'k1pro.png', 'k1pro.html'),
        ('k1plusv2', 'k1plus.png', 'k1pro.png', 'k1pro.html'),
        ('k3pro', 'k3pro.png', 'k3pro.png', 'k3pro.html'),
        ('e4hd', 'e4hd.png', 'e4hd.png', 'e4hd.html'),
        ('e4hdhybrid', 'e4hdhybrid.png', 'e4hd.png', 'e4hd.html'),
        ('e4hdultra', 'e4hdultra.png', 'e4hdcombo.png', 'e4hdcombo.html'),
        ('e4hdcombo', 'e4hdcombo.png', 'e4hdcombo.png', 'e4hdcombo.html'),
        ('tmtwin', 'tmtwin.png', 'tm1.png', 'tm1.html'),
        ('tm2t', 'tm2t.png', 'tm1.png', 'tm1.html'),
        ('tmsingle', 'tmsingle.png', 'tm2.png', 'tm2.html'),
        ('tmnano', 'tmnano.png', 'tm2.png', 'tm2.html'),
        ('tmnano2t', 'tmnano2t.png', 'tm2.png', 'tm2.html'),
        ('tmnano3t', 'tmnano3t.png', 'tm2.png', 'tm2.html'),
        ('tmnano2super', 'tmnano2super.png', 'tm2.png', 'tm2.html'),
        ('tmnanose', 'tmnanose.png', 'tm3.png', 'tm3.html'),
        ('tmnanosecombo', 'tmnanosecombo.png', 'tm3.png', 'tm3.html'),
        ('tmnanosem2', 'tmnanosem2.png', 'tm4.png', 'tm4.html'),
        ('tmnanosem2plus', 'tmnanosem2plus.png', 'tm4.png', 'tm4.html'),
        ('tmnanoseplus', 'tmnanoseplus.png', 'tm4.png', 'tm4.html'),
        ('tmnanom3', 'tmnanom3.png', 'tm5.png', 'tm5.html'),
        ('tmtwin4k', 'tmtwin4k.png', 'tm6.png', 'tm6.html'),
        ('tm4ksuper', 'tm4ksuper.png', 'tm6.png', 'tm6.html'),
        ('dinobot4kmini', 'dinobot4kmini.png', 'dinobot.png', 'dinobot.html'),
        ('dinobot4kplus', 'dinobot4kplus.png', 'dinobot.png', 'dinobot.html'),
        ('dinobot4k', 'dinobot4k.png', 'dinobot.png', 'dinobot.html'),
        ('dinobot4kse', 'dinobot4kse.png', 'dinobot.png', 'dinobot.html'),
        ('dinobot4kl', 'dinobot4kl.png', 'dinobot.png', 'dinobot.html'),
        ('dinobot4kpro', 'dinobot4kpro.png', 'dinobot.png', 'dinobot.html'),
        ('dinobotu55', 'dinobotu55.png', 'dinobot.png', 'dinobot.html'),
        ('dinoboth265', 'dinoboth265.png', 'dinobot.png', 'dinobot.html'),
        ('axashis4kcombo', 'axashis4kcombo.png', 'axas1.png', 'axas1.html'),
        ('axashis4kcomboplus', 'axashis4kcomboplus.png', 'axas1.png', 'axas1.html'),
        ('axashisc4k', 'axashisc4k.png', 'axas2.png', 'axas2.html'),
        ('axashistwin', 'axashistwin.png', 'axas3.png', 'axas3.html'),
        ('anadol4k', 'anadol4k.png', 'anadol1.png', 'anadol1.html'),
        ('anadol4kv2', 'anadol4kv2.png', 'anadol1.png', 'anadol1.html'),
        ('anadolprohd5', 'anadolprohd5.png', 'anadol3.png', 'anadol3.html'),
        ('iziboxx3', 'iziboxx3.png', 'izibox1.png', 'izibox1.html'),
        ('arivatwin', 'arivatwin.png', 'ariva.png', 'ariva.html'),
        ('arivacombo', 'arivacombo.png', 'ariva.png', 'ariva.html'),
        ('odroidc2', 'odroidc2.png', 'hardkernel.png', 'hardkernel.html'),
        ('cube', 'cube.png', 'cube.png', 'cube.html'),
        ('ebox5000', 'ebox5000.png', 'ebox5000.png', 'ebox5000.html'),
        ('ebox5100', 'ebox5100.png', 'ebox5000.png', 'ebox5000.html'),
        ('ebox7358', 'ebox7358.png', 'ebox5000.png', 'ebox5000.html'),
        ('eboxlumi', 'eboxlumi.png', 'ebox5000.png', 'ebox5000.html'),
        ('sogno8800hd', 'sogno8800hd.png', 'sogno.png', 'sogno.html'),
        ('uniboxhde', 'uniboxhde.png', 'uniboxhde.png', 'uniboxhde.html'),
        ('ventonhdx', 'ventonhdx.png', 'ini0.png', 'ini0.html'),
        ('sezam1000hd', 'sezam1000hd.png', 'ini2.png', 'ini2.html'),
        ('sezam5000hd', 'sezam5000hd.png', 'ini2.png', 'ini2.html'),
        ('mbmini', 'mbmini.png', 'ini3.png', 'ini3.html'),
        ('mbminiplus', 'mbminiplus.png', 'ini3.png', 'ini3.html'),
        ('mbhybrid', 'mbhybrid.png', 'ini3.png', 'ini3.html'),
        ('mbtwin', 'mbtwin.png', 'ini3.png', 'ini3.html'),
        ('mbultra', 'mbultra.png', 'ini3.png', 'ini3.html'),
        ('atemio5x00', 'atemio5x00.png', 'ini4.png', 'ini4.html'),
        ('atemio6000', 'atemio6000.png', 'ini4.png', 'ini4.html'),
        ('atemio6100', 'atemio6100.png', 'ini4.png', 'ini4.html'),
        ('atemio6200', 'atemio6200.png', 'ini4.png', 'ini4.html'),
        ('atemionemesis', 'atemionemesis.png', 'ini4.png', 'ini4.html'),
        ('xpeedlx', 'xpeedlx.png', 'ini4.png', 'ini4.html'),
        ('xpeedlx3', 'xpeedlx3.png', 'ini4.png', 'ini4.html'),
        ('sezammarvel', 'sezammarvel.png', 'ini4.png', 'ini4.html'),
        ('beyonwizt3', 'beyonwizt3.png', 'ini5.png', 'ini5.html'),
        ('bwidowx', 'bwidowx.png', 'ini6.png', 'ini6.html'),
        ('bwidowx2', 'bwidowx2.png', 'ini6.png', 'ini6.html'),
        ('beyonwizt2', 'beyonwizt2.png', 'ini7.png', 'ini7.html'),
        ('beyonwizt4', 'beyonwizt4.png', 'ini7.png', 'ini7.html'),
        ('opticumtt', 'opticumtt.png', 'ini8.png', 'ini8.html'),
        ('beyonwizu4', 'beyonwizu4.png', 'beyonwiz1.png', 'beyonwiz1.html'),
        ('beyonwizv2', 'beyonwizv2.png', 'beyonwiz2.png', 'beyonwiz2.html'),
        ('starsatlx', 'starsatlx.png', 'odinm6.png', 'odinm6.html'),
        ('axodin', 'axodin.png', 'odinm6.png', 'odinm6.html'),
        ('axodinc', 'axodinc.png', 'odinm6.png', 'odinm6.html'),
        ('classm', 'classm.png', 'odinm7.png', 'odinm7.html'),
        ('genius', 'genius.png', 'odinm7.png', 'odinm7.html'),
        ('evo', 'evo.png', 'odinm7.png', 'odinm7.html'),
        ('galaxym6', 'galaxym6.png', 'odinm7.png', 'odinm7.html'),
        ('maram9', 'maram9.png', 'odinm9.png', 'odinm9.html'),
        ('ustym4kpro', 'ustym4kpro.png', 'uclan.png', 'uclan.html'),
        ('valalinux', 'valalinux.png', 'vala.png', 'vala.html'),
        ('force4', 'force4.png', 'iqon1.png', 'iqon1.html'),
        ('iqonios100hd', 'iqonios100hd.png', 'iqon1.png', 'iqon1.html'),
        ('iqonios200hd', 'iqonios200hd.png', 'iqon1.png', 'iqon1.html'),
        ('iqonios300hd', 'iqonios300hd.png', 'iqon1.png', 'iqon1.html'),
        ('iqonios300hdv2', 'iqonios300hdv2.png', 'iqon1.png', 'iqon1.html'),
        ('force2se', 'force2se.png', 'iqon1.png', 'iqon1.html'),
        ('force2', 'force2.png', 'iqon1.png', 'iqon1.html'),
        ('force2plus', 'force2plus.png', 'iqon1.png', 'iqon1.html'),
        ('force2plushv', 'force2plushv.png', 'iqon1.png', 'iqon1.html'),
        ('force2nano', 'force2nano.png', 'iqon1.png', 'iqon1.html'),
        ('force1', 'force1.png', 'iqon2.png', 'iqon2.html'),
        ('force1plus', 'force1plus.png', 'iqon2.png', 'iqon2.html'),
        ('worldvisionf1', 'worldvisionf1.png', 'iqon2.png', 'iqon2.html'),
        ('worldvisionf1plus', 'worldvisionf1plus.png', 'iqon2.png', 'iqon2.html'),
        ('force3uhdplus', 'force3uhdplus.png', 'iqon3.png', 'iqon3.html'),
        ('force3uhd', 'force3uhd.png', 'iqon3.png', 'iqon3.html'),
        ('twinboxlcd', 'twinboxlcd.png', 'red1.png', 'red1.html'),
        ('singleboxlcd', 'singleboxlcd.png', 'red2.png', 'red2.html'),
        ('twinboxlcdci5', 'twinboxlcdci5.png', 'red2.png', 'red2.html'),
        ('triplex', 'triplex.png', 'triplex.png', 'triplex.html'),
        ('ultrabox', 'ultrabox.png', 'triplex.png', 'triplex.html'),
        ('xpeedc', 'xpeedc.png', 'gi1.png', 'gi1.html'),
        ('mediabox', 'mediabox.png', 'mediabox.png', 'mediabox.html'),
        ('9900lx', '9900lx.png', 'protek1.png', 'protek1.html'),
        ('9910lx', '9910lx.png', 'protek2.png', 'protek2.html'),
        ('9911lx', '9911lx.png', 'protek2.png', 'protek2.html'),
        ('protek4k', 'protek4k.png', 'protek2.png', 'protek2.html'),
        ('9920lx', '9920lx.png', 'protek2.png', 'protek2.html'),
        ('protek4kx1', 'protek4kx1.png', 'protek3.png', 'protek3.html'),
        ('enfinity', 'enfinity.png', 'evo1.png', 'evo1.html'),
        ('x2plus', 'x2plus.png', 'evo2.png', 'evo2.html'),
        ('xcombo', 'xcombo.png', 'evo3.png', 'evo3.html'),
        ('x1plus', 'x1plus.png', 'evo3.png', 'evo3.html'),
        ('t2cable', 't2cable.png', 'evo4.png', 'evo4.html'),
        ('evomini', 'evomini.png', 'evo5.png', 'evo5.html'),
        ('evominiplus', 'evominiplus.png', 'evo5.png', 'evo5.html'),
        ('evoslim', 'evoslim.png', 'evo8.png', 'evo8.html'),
        ('evoslimse', 'evoslimse.png', 'evo8.png', 'evo8.html'),
        ('evoslimt2c', 'evoslimt2c.png', 'evo8.png', 'evo8.html'),
        ('sf108', 'sf108.png', 'sf108.png', 'sf108.html'),
        ('sf208', 'sf208.png', 'sf2x8.png', 'sf2x8.html'),
        ('sf228', 'sf228.png', 'sf2x8.png', 'sf2x8.html'),
        ('sf238', 'sf238.png', 'sf2x8.png', 'sf2x8.html'),
        ('sf3038', 'sf3038.png', 'sf3038.png', 'sf3038.html'),
        ('sf128', 'sf128.png', 'sf3038.png', 'sf3038.html'),
        ('sf138', 'sf138.png', 'sf3038.png', 'sf3038.html'),
        ('sf4008', 'sf4008.png', 'sf3038.png', 'sf3038.html'),
        ('sf5008', 'sf5008.png', 'sf5008.png', 'sf5008.html'),
        ('sf8008', 'sf8008.png', 'sf8008.png', 'sf8008.html'),
        ('sf8008m', 'sf8008m.png', 'sf8008.png', 'sf8008.html'),
        ('sf98', 'sf98.png', 'sf98.png', 'sf98.html'),
        ('bre2ze', 'bre2ze.png', 'wwio1.png', 'wwio1.html'),
        ('bre2ze4k', 'bre2ze4k.png', 'wwio1.png', 'wwio1.html'),
        ('bre2zet2c', 'bre2zet2c.png', 'wwio1.png', 'wwio1.html'),
        ('tiviarmin', 'tiviarmin.png', 'tiviar1.png', 'tiviar1.html'),
        ('tiviaraplus', 'tiviaraplus.png', 'tiviar1.png', 'tiviar1.html'),
        ('odin2hybrid', 'odin2hybrid.png', 'ax1.png', 'ax1.html'),
        ('odinplus', 'odinplus.png', 'ax1.png', 'ax1.html'),
        ('axultra', 'axultra.png', 'ax51.png', 'ax51.html'),
        ('enibox', 'enibox.png', 'hdbox.png', 'hdbox.html'),
        ('mago', 'mago.png', 'relook.png', 'relook.html'),
        ('tyrant', 'tyrant.png', 'tyrant.png', 'tyrant.html'),
        ('marvel1', 'marvel1.png', 'visionnet.png', 'visionnet.html'),
        ('raspberrypi', 'raspberrypi.png', 'dmm1.png', 'dmm1.html'),
        ('raspberrypi0', 'raspberrypi0.png', 'dmm1.png', 'dmm1.html'),
        ('raspberrypi2', 'raspberrypi2.png', 'dmm1.png', 'dmm1.html'),
        ('raspberrypi3', 'raspberrypi3.png', 'dmm1.png', 'dmm1.html'),
        ('raspberrypi4', 'raspberrypi4.png', 'dmm1.png', 'dmm1.html'),
        ('forever_2424hd', 'forever_2424hd.png', 'fulan.png', 'fulan.html'),
        ('forever_3434hd', 'forever_3434hd.png', 'fulan.png', 'fulan.html'),
        ('forever_9898hd', 'forever_9898hd.png', 'fulan.png', 'fulan.html'),
        ('forever_nanosmart', 'forever_nanosmart.png', 'fulan.png', 'fulan.html'),

    ]

    import os

    pluginpath = "%s%s" % (d.getVar('D', True), d.getVar('PLUGINPATH', True))
    images = "%s/public/images/" % pluginpath
    keymaps = "%s/public/static/" % pluginpath

    target_box = 'unknown.png'
    target_remote = 'ow_remote.png'
    target_keymap = ''
    exception = ''

    for x in boxtypes:
        if x[0] == d.getVar('MACHINE', True):
            target_box = x[1]
            target_remote = x[2]
            target_keymap = x[3]
            if x[0] == 'et6x00':
                exception = 'et6500.png'
            elif x[0] == 'et9x00':
                exception = 'et9500.png'
            elif x[0] == 'azboxhd':
                exception = 'azboxelite.png'
            break

    for root, dirs, files in os.walk(images + 'boxes', topdown=False):
        for name in files:
            if target_box != name and name != 'unknown.png' and exception != name:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(images + 'remotes', topdown=False):
        for name in files:
            if target_remote != name and name != 'ow_remote.png' and exception != name:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(keymaps + 'remotes', topdown=False):
        for name in files:
            if target_keymap != name:
                os.remove(os.path.join(root, name))
}

addtask do_cleanup after do_populate_sysroot before do_package
RPROVIDES_${PN} =+ "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${PN}-vxg ${PN}-terminal ${PN}-themes ${PN}-webtv", "${PN}-terminal", d)}"
PACKAGES =+ "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${PN}-vxg ${PN}-terminal ${PN}-themes ${PN}-webtv", "", d)}"
FILES_${PN}-vxg = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/vxg", "", d)}"
FILES_${PN}-themes = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/themes", "", d)}"
FILES_${PN}-webtv = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/webtv", "", d)}"

DESCRIPTION_${PN}-terminal = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "CLI for OpenWebif", d)}"
RDEPENDS_${PN}-terminal = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "${PN} shellinabox", d)}"
RREPLACES_${PN}-terminal = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-terminal", d)}"
RCONFLICTS_${PN}-terminal = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-terminal", d)}"
RPROVIDES_${PN}-terminal =+ "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-terminal", d)}"
