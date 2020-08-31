SUMMARY = "Driver for Realtek USB wireless device 8192fu"
HOMEPAGE = "http://www.realtek.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://wlan0dhcp;md5=069fc07a0c587af26235837dc342eb25"

inherit module machine_kernel_pr

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = " \
	https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rtl8192FU_rtl8725AU_WiFi_linux_v5.8.6.4_37082.20200716_COEX20190910-0d02.zip \
	file://0001-makefile.patch \
	file://0002-fix-for-4.19.patch \
	file://0003-fix-for-5.1.patch \
	file://0004-fix-for-5.6.patch \
	file://0005-fix-for-5.8.patch \
	"

SRC_URI[md5sum] = "35680c65525ca92668fe866f3f005e6b"
SRC_URI[sha256sum] = "f2530413205ea4c9f5a74d144bc0dff4b8a2b9816e079d8adb12ccd032633444"

S = "${WORKDIR}"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR} KDIR=${STAGING_KERNEL_DIR} KSRC=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/8192fu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}

do_package_qa() {
}
