DESCRIPTION = "Open Vision version info"
SECTION = "base"
PRIORITY = "required"
require conf/license/license-gplv2.inc

PV = "${VISIONVERSION}"
PR = "${VISIONREVISION}"

do_configure[nostamp] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "${sysconfdir}"

S = "${WORKDIR}"

PACKAGES = "${PN}"

do_install() {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/openvision
	echo "STB=${MACHINE}" > ${D}${sysconfdir}/image-version
	echo "${MACHINE}" > ${D}${sysconfdir}/openvision/model
	echo "Brand=${BOX_BRAND}" >> ${D}${sysconfdir}/image-version
	echo "${BOX_BRAND}" > ${D}${sysconfdir}/openvision/brand
	echo "Platform=${STB_PLATFORM}" >> ${D}${sysconfdir}/image-version
	echo "${STB_PLATFORM}" > ${D}${sysconfdir}/openvision/platform
	echo "box_type=${MACHINE}" >> ${D}${sysconfdir}/image-version
	echo "build_type=0" >> ${D}${sysconfdir}/image-version
	echo "machine_brand=${BOX_BRAND}" >> ${D}${sysconfdir}/image-version
	echo "machine_name=${MACHINE}" >> ${D}${sysconfdir}/image-version
	echo "version=${VISIONVERSION}-${VISIONREVISION}" >> ${D}${sysconfdir}/image-version
	echo "visionversion=${VISIONVERSION}" >> ${D}${sysconfdir}/image-version
	echo "${VISIONVERSION}" > ${D}${sysconfdir}/openvision/visionversion
	echo "visionrevision=${VISIONREVISION}" >> ${D}${sysconfdir}/image-version
	echo "${VISIONREVISION}" > ${D}${sysconfdir}/openvision/visionrevision
	echo "visionlanguage=${VISIONLANGUAGE}" >> ${D}${sysconfdir}/image-version
	echo "${VISIONLANGUAGE}" > ${D}${sysconfdir}/openvision/visionlanguage
	echo "compiledby=${DEVELOPER_NAME}" >> ${D}${sysconfdir}/image-version
	echo "${DEVELOPER_NAME}" > ${D}${sysconfdir}/openvision/developername
	echo "feedsurl=${DISTRO_FEED_URI}" >> ${D}${sysconfdir}/image-version
	echo "${DISTRO_FEED_URI}" > ${D}${sysconfdir}/openvision/feedsurl
	echo "build=${VISIONREVISION}" >> ${D}${sysconfdir}/image-version
	echo "date=${DATETIME}" >> ${D}${sysconfdir}/image-version
	echo "comment=Open Vision" >> ${D}${sysconfdir}/image-version
	echo "target=9" >> ${D}${sysconfdir}/image-version
	echo "creator=Open Vision developers" >> ${D}${sysconfdir}/image-version
	echo "url=https://openvision.tech" >> ${D}${sysconfdir}/image-version
	echo "catalog=https://github.com/OpenVisionE2" >> ${D}${sysconfdir}/image-version
	echo "distro=${DISTRO_NAME}" >> ${D}${sysconfdir}/image-version
	echo "${DISTRO_NAME}" > ${D}${sysconfdir}/openvision/distro
	echo "imageversion=${DISTRO_VERSION}" >> ${D}${sysconfdir}/image-version
	echo "imagedevbuild=${DEVELOPER_BUILD_VERSION}" >> ${D}${sysconfdir}/image-version
	echo "imagetype=${DISTRO_TYPE}" >> ${D}${sysconfdir}/image-version
	echo "oe=${BUILD_VERSION}" >> ${D}${sysconfdir}/image-version
	echo "${BUILD_VERSION}" > ${D}${sysconfdir}/openvision/oe
	echo "python=${PREFERRED_VERSION_python}" >> ${D}${sysconfdir}/image-version
	echo "${PREFERRED_VERSION_python}" > ${D}${sysconfdir}/openvision/python
	echo "mediaservice=${PREFERRED_PROVIDER_virtual/enigma2-mediaservice}" >> ${D}${sysconfdir}/image-version
	echo "${PREFERRED_PROVIDER_virtual/enigma2-mediaservice}" > ${D}${sysconfdir}/openvision/mediaservice
	echo "multilib=${HAVE_MULTILIB}" >> ${D}${sysconfdir}/image-version
	echo "${HAVE_MULTILIB}" >> ${D}${sysconfdir}/openvision/multilib
	echo "architecture=${DEFAULTTUNE}" >> ${D}${sysconfdir}/image-version
	echo "${DEFAULTTUNE}" > ${D}${sysconfdir}/openvision/architecture
	echo "socfamily=${SOC_FAMILY}" >> ${D}${sysconfdir}/image-version
	echo "${SOC_FAMILY}" > ${D}${sysconfdir}/openvision/socfamily
	echo "fpu=${TARGET_FPU}" >> ${D}${sysconfdir}/image-version
	echo "display-type=${DISPLAY_TYPE}" >> ${D}${sysconfdir}/image-version
	echo "blindscanbinary=${BLINDSCAN_BINARY}" >> ${D}${sysconfdir}/image-version
	echo "${BLINDSCAN_BINARY}" > ${D}${sysconfdir}/openvision/blindscanbinary
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "1", "0", d)}" = "1" ]; then
		echo "small-flash=${HAVE_SMALLFLASH}" >> ${D}/etc/image-version
		echo "smallflash" > ${D}${sysconfdir}/openvision/smallflash
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "middleflash", "1", "0", d)}" = "1" ]; then
		echo "middle-flash=${HAVE_MIDDLEFLASH}" >> ${D}/etc/image-version
		echo "middleflash" > ${D}${sysconfdir}/openvision/middleflash
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "transcoding", "1", "0", d)}" = "1" ]; then
		echo "transcoding=${HAVE_TRANSCODING}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "multitranscoding", "1", "0", d)}" = "1" ]; then
		echo "multitranscoding=${HAVE_MULTITRANSCODING}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "HDMI", "1", "0", d)}" = "1" ]; then
		echo "HDMI=${HAVE_HDMI}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "YUV", "1", "0", d)}" = "1" ]; then
		echo "YUV=${HAVE_YUV}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "RCA", "1", "0", d)}" = "1" ]; then
		echo "RCA=${HAVE_RCA}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "AV_JACK", "1", "0", d)}" = "1" ]; then
		echo "AV_JACK=${HAVE_AV_JACK}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "SCART", "1", "0", d)}" = "1" ]; then
		echo "SCART=${HAVE_SCART}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "DVI", "1", "0", d)}" = "1" ]; then
		echo "DVI=${HAVE_DVI}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "SVIDEO", "1", "0", d)}" = "1" ]; then
		echo "SVIDEO=${HAVE_SVIDEO}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "HDMI-IN-HD", "1", "0", d)}" = "1" ]; then
		echo "HDMI-IN-HD=${HAVE_HDMI_IN_HD}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "HDMI-IN-FHD", "1", "0", d)}" = "1" ]; then
		echo "HDMI-IN-FHD=${HAVE_HDMI_IN_FHD}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "wol", "1", "0", d)}" = "1" ]; then
		echo "wol=${HAVE_WOL}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "ci", "1", "0", d)}" = "1" ]; then
		echo "ci=${HAVE_CI}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "vfdsymbol", "1", "0", d)}" = "1" ]; then
		echo "vfdsymbol=${HAVE_VFDSYMBOL}" >> ${D}${sysconfdir}/image-version
	fi
	echo "${IMAGEDIR}" > ${D}${sysconfdir}/openvision/imagedir
	echo "${IMAGE_FSTYPES}" > ${D}${sysconfdir}/openvision/imagefs
	echo "${MTD_BOOTFS}" > ${D}${sysconfdir}/openvision/mtdbootfs
	echo "${MTD_ROOTFS}" > ${D}${sysconfdir}/openvision/mtdrootfs
	echo "${MTD_KERNEL}" > ${D}${sysconfdir}/openvision/mtdkernel
	echo "${ROOTFS_FILE}" > ${D}${sysconfdir}/openvision/rootfile
	echo "${KERNEL_FILE}" > ${D}${sysconfdir}/openvision/kernelfile
	echo "${MKUBIFS_ARGS}" > ${D}${sysconfdir}/openvision/mkubifs
	echo "${UBINIZE_ARGS}" > ${D}${sysconfdir}/openvision/ubinize
}

pkg_postinst_ontarget_${PN} () {
touch /etc/enigma2/settings
if ! grep -qs "config.plugins.CacheFlush" cat /etc/enigma2/settings ; then
	echo "config.plugins.CacheFlush.free_default=2039" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.timescrinfo=3" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.enable=true" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.timeout=5" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.uncached=0" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.where=1" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.sync=true" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.scrinfo=false" >>/etc/enigma2/settings
fi
}

do_install[vardepsexclude] += "DATETIME"
