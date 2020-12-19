SUMMARY = "DVB Firmware files"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"
INSANE_SKIP_${PN} = "arch"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/dvb-firmwares.tar.xz"

SRC_URI[md5sum] = "12ba0deb967063aba55df92adb445dc6"
SRC_URI[sha256sum] = "53784ca28c964bde9843f7ffcffb798dd62e4ab3f5ba9b43eef4060943868bac"

S = "${WORKDIR}/dvb-firmwares"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	cp -fr --preserve=links ${S}/* ${D}${nonarch_base_libdir}/firmware/
}
