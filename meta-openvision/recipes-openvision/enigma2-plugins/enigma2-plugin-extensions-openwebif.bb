DESCRIPTION = "Control your receiver with a browser"
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
	python-six \
	python-unixadmin \
	"

inherit gitpkgv distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/OpenWebif.git;protocol=git"

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
        ('dm800', 'dm800.png', 'dmm1.png', 'dmm1.html'),
        ('wetekplay', 'wetekplay.png', 'wetek.png', 'wetek.html'),
        ('wetekplay2', 'wetekplay2.png', 'wetek2.png', 'wetek2.html'),
        ('wetekhub', 'wetekhub.png', 'wetek3.png', 'wetek3.html'),
        ('alien5', 'alien5.png', 'amiko3.png', 'amiko3.html'),
        ('k1pro', 'k1pro.png', 'k1pro.png', 'k1pro.html'),
        ('k2pro', 'k2pro.png', 'k1pro.png', 'k1pro.html'),
        ('k2prov2', 'k2pro.png', 'k1pro.png', 'k1pro.html'),
        ('k1plus', 'k1plus.png', 'k1pro.png', 'k1pro.html'),
        ('k1plusv2', 'k1plus.png', 'k1pro.png', 'k1pro.html'),
        ('k3pro', 'k3pro.png', 'k3pro.png', 'k3pro.html'),
        ('odroidc2', 'odroidc2.png', 'hardkernel.png', 'hardkernel.html'),
        ('cube', 'cube.png', 'cube.png', 'cube.html'),
        ('raspberrypi', 'raspberrypi.png', 'dmm1.png', 'dmm1.html'),
        ('raspberrypi0', 'raspberrypi0.png', 'dmm1.png', 'dmm1.html'),
        ('raspberrypi2', 'raspberrypi2.png', 'dmm1.png', 'dmm1.html'),
        ('raspberrypi3', 'raspberrypi3.png', 'dmm1.png', 'dmm1.html'),
        ('raspberrypi4', 'raspberrypi4.png', 'dmm1.png', 'dmm1.html'),
    ]

    import os

    pluginpath = "%s%s" % (d.getVar('D', True), d.getVar('PLUGINPATH', True))
    images = "%s/public/images/" % pluginpath
    keymaps = "%s/public/static/" % pluginpath

    target_box = 'unknown.png'
    target_remote = 'ow_remote.png'
    target_keymap = ''
    exception = []

    for x in boxtypes:
        if x[0] == d.getVar('MACHINE', True):
            target_box = x[1]
            target_remote = x[2]
            target_keymap = x[3]
            if x[0] == 'et6x00':
                exception = [et6500.png]
            elif x[0] == 'et9x00':
                exception = [et9500.png]
            elif x[0] == 'azboxhd':
                exception = [azboxelite.png]
            break

    for root, dirs, files in os.walk(images + 'boxes', topdown=False):
        for name in files:
            if target_box != name and name != 'unknown.png' and name not in exception:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(images + 'remotes', topdown=False):
        for name in files:
            if target_remote != name and name != 'ow_remote.png' and name not in exception:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(keymaps + 'remotes', topdown=False):
        for name in files:
            if target_keymap != name:
                os.remove(os.path.join(root, name))
}

addtask do_cleanup after do_populate_sysroot before do_package
RPROVIDES_${PN} += "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${PN}-vxg ${PN}-terminal ${PN}-themes ${PN}-webtv", "${PN}-terminal", d)}"
PACKAGES += "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${PN}-vxg ${PN}-terminal ${PN}-themes ${PN}-webtv", "", d)}"
FILES_${PN}-vxg = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/vxg", "", d)}"
FILES_${PN}-themes = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/themes", "", d)}"
FILES_${PN}-webtv = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/webtv", "", d)}"

DESCRIPTION_${PN}-terminal = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "CLI for OpenWebif", d)}"
RDEPENDS_${PN}-terminal = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "${PN} shellinabox", d)}"
RREPLACES_${PN}-terminal = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-terminal", d)}"
RCONFLICTS_${PN}-terminal = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-terminal", d)}"
RPROVIDES_${PN}-terminal += "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-terminal", d)}"
